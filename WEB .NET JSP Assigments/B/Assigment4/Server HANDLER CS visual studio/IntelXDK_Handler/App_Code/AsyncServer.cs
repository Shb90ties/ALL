using System;
using System.Collections.Generic;
using System.Web.Script.Serialization;
using System.Linq;
using System.Web;
using System.Threading;
using System.Drawing;
using System.Globalization;

public class AsyncServer
{
    private static Arguments[] Game = new Arguments[16];
    private static Boolean activeGame = false;
    private static object lock_ = new object();
    private static int emptyIndx;
    private static List<AsyncResult> clients = new List<AsyncResult>();

    public static void Add(AsyncResult current)
    {
        lock(lock_)
        {
            current.ClientGuid = Guid.NewGuid().ToString();
            clients.Add(current);
            current._context.Response.Write(current.ClientGuid.ToString());
        }
    }

    public static void Remove(AsyncResult current)
    {
        lock(lock_)
        {
            clients.Remove(current);
        }
    }

    public static void update(AsyncResult current, string guID)
    {
        lock(lock_)
        {
            AsyncResult client = clients.Find
                (delegate (AsyncResult c) { return (c.ClientGuid == guID); });
            if( client != null )
            {
                client._context = current._context;
                client._state = current._state;
                client._callback = current._callback;
            }
        }
    }

    public static void getGame(AsyncResult current)
    {
        lock (lock_)
        {
            if( activeGame == true )
            {
                JavaScriptSerializer serializr = new JavaScriptSerializer();
                string GameInJSON = serializr.Serialize(Game);
                current._context.Response.Write(GameInJSON);
            }
            else
            {
                CreateGame(current);
            }
        }
    }

    public static void CreateGame(AsyncResult current)
    {
        lock(lock_)
        {
            Game = new Arguments[16];
            Random random = new Random();
            string[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
            for(int i=0; i < 15;i++)
            {
                int a = random.Next(15); int b = random.Next(15);
                string t = numbers[a]; numbers[a] = numbers[b]; numbers[b] = t;
            }
            for(int i=0; i < 15;i++)
            {
                Color temp = Color.FromArgb(random.Next(200), random.Next(200), random.Next(200));
                Game[i] = new Arguments(numbers[i], ColorTranslator.ToHtml(temp));
            }
            Game[15] = new Arguments(); emptyIndx = 15;
            activeGame = true;

            // printing array in output window //
            System.Diagnostics.Debug.WriteLine("_______NEW GAME_______");
            for (int print=0; print<16; print++)
            {
                System.Diagnostics.Debug.WriteLine("( " + Game[print].HTMLcolorCode + "," + Game[print].num + ")");
            }


            JavaScriptSerializer serializr = new JavaScriptSerializer();
            string GameInJSON = serializr.Serialize(Game);
            //postToAll("Game|" + GameInJSON);
            if( current != null) { current._context.Response.Write(GameInJSON); }
        }
    }

    private static void postToAll(string post)
    {
        foreach (AsyncResult i in clients)
        {
            if( i._context.Session != null )
            {
                i._context.Response.Write(post);
                i.CompleteRequest();
            }
        }
    }

    public static void getAverage(AsyncResult current,string HTMLcolorA, string HTMLcolorB)
    {
        lock(lock_)
        {
            int ColorNumberA = Int32.Parse(HTMLcolorA.Replace("#", ""), NumberStyles.HexNumber);
            Color A = Color.FromArgb(ColorNumberA);
            int ColorNumberB = Int32.Parse(HTMLcolorB.Replace("#", ""), NumberStyles.HexNumber);
            Color B = Color.FromArgb(ColorNumberB);
            Color avg = Color.FromArgb(((A.R + B.R) / 2), ((A.G + B.G) / 2), ((A.B + B.B) / 2));
            string HTMLavg = ColorTranslator.ToHtml(avg);

            JavaScriptSerializer serializr = new JavaScriptSerializer();
            current._context.Response.Write(HTMLavg);
        }
    }

    public static void move(AsyncResult current, string num)
    {
        lock(lock_)
        {
            int myIndx = 0;
            for (int i = 0; i < 16; i++)
            {
                if(Game[i].num == num) { myIndx = i;  break; }
            }
            if( myIndx+4 == emptyIndx || myIndx-4 == emptyIndx ||
                    (myIndx+1 == emptyIndx && (myIndx+1)%4 != 0) || (myIndx-1 == emptyIndx && (myIndx)%4 != 0))
            {
                Arguments temp = new Arguments(Game[myIndx].num, Game[myIndx].HTMLcolorCode);
                Game[myIndx].Equals_(Game[emptyIndx]);
                Game[emptyIndx].Equals_(temp);
                emptyIndx = myIndx;

                JavaScriptSerializer serializr = new JavaScriptSerializer();
                current._context.Response.Write("switch|"+num+"|"+myIndx.ToString());
                //postToAll("switch|"+num+"|"+myIndx.ToString());
            }
        }
    }

    public static void CheckWinner(AsyncResult current)
    {
        lock(lock_)
        {
            if(Game[0].num == "1" && Game[1].num == "2")
            {
                CreateGame(null);
                current._context.Response.Write("new game been created");
            }
            else
            {
                current._context.Response.Write("Game is not finished");
            }
        }
    }

    public static void GoodBye(AsyncResult current)
    {
        current._context.Response.Write("GoodBye cruel World from ASP.NET server");
    }
}