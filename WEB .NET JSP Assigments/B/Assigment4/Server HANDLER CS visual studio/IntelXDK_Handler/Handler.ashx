<%@ WebHandler Language="C#" Class="Handler" %>

using System;
using System.Web;
using System.Threading;

public class Handler : IHttpAsyncHandler
{
    private static Boolean firstRun = true;

    public Handler()
    {
        System.Diagnostics.Debug.WriteLine("Handler been created!!!");
        // will show up in the Output window || View > Output // or // Ctrl+Alt+O
        if (firstRun) { AsyncServer.CreateGame(null); firstRun = false; }

    }

    public IAsyncResult BeginProcessRequest(HttpContext ctx, AsyncCallback cb, Object obj)
    {
        AsyncResult currentAsyncState = new AsyncResult(ctx, cb, obj);
        ThreadPool.QueueUserWorkItem(new WaitCallback(AnalyzeRequest), currentAsyncState);
        return currentAsyncState;
    }

    public void AnalyzeRequest(Object obj)
    {
        AsyncResult current = obj as AsyncResult;
        current._context.Response.ContentType = "application/x-www-form-urlencoded";
        string request = "";
        if( current._context.Request.QueryString["request"] != null )
        {
            request = current._context.Request.QueryString["request"];
        }
        System.Diagnostics.Debug.WriteLine("Request of : "+request+" Came in");
        //AsyncServer.CreateGame(null);
        switch(request)
        {
            case "Register":
                {
                    AsyncServer.Add(current);
                    break;
                }
            case "Remove":
                {
                    AsyncServer.Remove(current);
                    break;
                }
            case "Update":
                {
                    if(current._context.Request.QueryString["guID"] != null)
                    {
                        AsyncServer.update(current, current._context.Request.QueryString["guID"]);
                    }
                    break;
                }
            case "GetGame":
                {
                    AsyncServer.getGame(current);
                    break;
                }
            case "NewGame":
                {
                    AsyncServer.CreateGame(current);
                    break;
                }
            case "Average":
                {
                    if( current._context.Request.QueryString["colorA"] != null &&
                          current._context.Request.QueryString["colorB"] != null  )
                    {
                        AsyncServer.getAverage(current, current._context.Request.QueryString["colorA"], current._context.Request.QueryString["colorB"]);
                    }
                    break;
                }
            case "Move":
                {
                    if( current._context.Request.QueryString["number"] != null )
                    {
                        AsyncServer.move(current, current._context.Request.QueryString["number"]);
                    }
                    break;
                }
            case "Winner":
                {
                    AsyncServer.CheckWinner(current);
                    break;
                }
        }
        current.CompleteRequest();
    }

    public void ProcessRequest (HttpContext context){}

    public void EndProcessRequest(IAsyncResult ar){}

    public bool IsReusable
    {
        get { return true; }
    }

}