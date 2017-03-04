<%@ WebHandler Language="C#" Class="Handler" %>

using System;
using System.Web;
using System.Threading;
using System.Web.Script.Serialization;

public class Handler : IHttpAsyncHandler , System.Web.SessionState.IReadOnlySessionState
{
    //private static Boolean firstRun = true;

    //public Handler()
    //{
        // will show up in the Output window || View > Output // or // Ctrl+Alt+O
        //if (firstRun) { AsyncServer.CreateGame(null); firstRun = false; }
    //}

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
        switch(request)
        {
            case "Register":
                {
                    AsyncServer.Add(current);
                    break;
                }
            case "Update":
                {
                    AsyncServer.update(current, current._context.Request.QueryString["from"]);
                    break;
                }
            case "GetGame":
                {
                    AsyncServer.getGame(current);
                    break;
                }
            case "Move":
                {
                    if( current._context.Request.QueryString["number"] != null &&
                        current._context.Request.QueryString["BGcolor"] != null )
                    {
                        string BGcolor = current._context.Request.QueryString["BGcolor"];
                        if(BGcolor[0] != '#'){   BGcolor = "#" + BGcolor;    }
                        AsyncServer.move(current._context.Request.QueryString["number"], current._context.Request.QueryString["BGcolor"]);
                    }
                    break;
                }
        }
    }

    public void ProcessRequest (HttpContext context){}

    public void EndProcessRequest(IAsyncResult ar){}

    public bool IsReusable
    {
        get { return true; }
    }

}