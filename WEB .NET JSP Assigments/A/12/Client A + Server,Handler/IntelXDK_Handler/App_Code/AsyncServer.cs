using System;
using System.Collections.Generic;
using System.Web.Script.Serialization;
using System.Linq;
using System.Web;
using System.Threading;
using System.Drawing;
using System.Globalization;

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
// for XML //
using System.Xml.Serialization;

public class AsyncServer
{
    private static Arguments[] Game;
    //private static Boolean activeGame = false;
    private static object lock_ = new object();
    private static object lock_create = new object();
    //private static int emptyIndx;
    private static List<AsyncResult> clients = new List<AsyncResult>();
    private static AsyncResult wait_cli;

    public static void Add(AsyncResult current)
    {
        lock(lock_)
        {
            current.ClientGuid = Guid.NewGuid().ToString();
            //clients.Add(current);
            sendMessage(current, current.ClientGuid.ToString());
        }
    }

    public static void Remove(string guID,AsyncResult current)
    {
        lock(lock_)
        {
            AsyncResult client = clients.Find
                (delegate(AsyncResult cs) { return (cs.ClientGuid == guID); });
            if(client != null)
            {
                clients.Remove(client);
            }
            current.CompleteRequest();
        }
    }

    public static void update(AsyncResult current,String from)
    {
        lock(lock_)
        {
            clients.Add(current);
            System.Diagnostics.Debug.WriteLine("add to update request from "+from);
        }
    }

    public static void getGame(AsyncResult current)
    {
        lock (lock_)
        {
            // use game in place boolean
            if( Game != null )
            {
                JavaScriptSerializer serializr = new JavaScriptSerializer();
                string GameInJSON = serializr.Serialize(Game);
                sendMessage(current, GameInJSON);
            }
            else
            {
                CreateGame(current);
            }
        }
    }

    public static void CreateGame(AsyncResult current)
    {
        lock(lock_create)
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
            Game[15] = new Arguments(); //emptyIndx = 15;
            //activeGame = true;

             
            System.Diagnostics.Debug.WriteLine("_______NEW GAME_______");       // print on debugger , View -> Output
            for (int print=0; print<16; print++)
            {
                System.Diagnostics.Debug.WriteLine("( " + Game[print].HTMLcolorCode + "," + Game[print].num + ")");
            }
            System.Diagnostics.Debug.WriteLine("_______CLIENTS_______");
            foreach(AsyncResult i in clients)
            {
                System.Diagnostics.Debug.WriteLine(i.ClientGuid);
            }

            //SaveGame(Game);

            JavaScriptSerializer serializr = new JavaScriptSerializer();
            string GameInJSON = serializr.Serialize(Game);
            if (current != null) { sendMessage(current, GameInJSON); }
        }
    }

    private static string getAverage(string HTMLcolorA, string HTMLcolorB)
    {
        int ColorNumberA = Int32.Parse(HTMLcolorA.Replace("#", ""), NumberStyles.HexNumber);
        Color A = Color.FromArgb(ColorNumberA);
        int ColorNumberB = Int32.Parse(HTMLcolorB.Replace("#", ""), NumberStyles.HexNumber);
        Color B = Color.FromArgb(ColorNumberB);
        Color avg = Color.FromArgb(((A.R + B.R) / 2), ((A.G + B.G) / 2), ((A.B + B.B) / 2));
        return ColorTranslator.ToHtml(avg);
    }

    public static void move(string num,string BGcolor)
    {
        lock(lock_)
        {
            int myIndx = 0; int emptyIndx = 0; string clickedColor = "#ffffff";
            for (int i = 0; i < 16; i++)
            {
                if (Game[i].num.Equals(num)) { myIndx = i; clickedColor = Game[i].HTMLcolorCode; }
                if (Game[i].num.Equals("0")) { emptyIndx = i; }
            }
            if( myIndx+4 == emptyIndx || myIndx-4 == emptyIndx ||
                    (myIndx+1 == emptyIndx && (myIndx+1)%4 != 0) || (myIndx-1 == emptyIndx && (myIndx)%4 != 0))
            {
                Arguments temp = new Arguments(Game[myIndx].num, Game[myIndx].HTMLcolorCode);
                Game[myIndx].Equals_(Game[emptyIndx]);
                Game[emptyIndx].Equals_(temp);
                String avgColor = getAverage(clickedColor, BGcolor);
                String post = "switch|" + num + "|" + myIndx.ToString() + "|" + avgColor;
                if (Game[0].num == "1" && Game[1].num == "2")
                {
                    CreateGame(null);
                    post = "switchFinish|" + num + "|" + myIndx.ToString() + "|" + avgColor;
                }
                foreach (AsyncResult i in clients) 
                {   sendMessage(i, post);   }
                clients.Clear();
            }
        }
    }

    private static void sendMessage(AsyncResult current,String message)
    {
        if( current != null || current._context.Session != null )
        {
            current._context.Response.Write(message);
            current.CompleteRequest();
            System.Diagnostics.Debug.WriteLine("posted : "+message);
        }
        else
        {
            System.Diagnostics.Debug.WriteLine("Null session Cannot print to client");
        }
    }

    public static void resetVirables(AsyncResult current)
    {
        Game = null;
        clients.Clear();
        lock_ = new object();
        System.Diagnostics.Debug.WriteLine("reset all static virables");
        if (current != null) { current.CompleteRequest(); }
    }
}