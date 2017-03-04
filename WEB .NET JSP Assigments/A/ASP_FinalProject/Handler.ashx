<%@ WebHandler Language="C#" Class="Handler" %>

using System;
using System.Web;

using System.Threading;
using System.Web.Script.Serialization;

public class Handler : IHttpAsyncHandler, System.Web.SessionState.IReadOnlySessionState
{
    public IAsyncResult BeginProcessRequest(HttpContext ctx,AsyncCallback cb,Object obj)
    {
        AsyncResult current = new AsyncResult(ctx, cb, obj);
        ThreadPool.QueueUserWorkItem(new WaitCallback(Analyze_Request), current);
        return current;
    }

    public void Analyze_Request(Object current)
    {
        AsyncResult client = current as AsyncResult;
        client.context_.Response.ContentType = "application/x-www-form-urlencoded";
        if (client.context_.Request.QueryString["cmd"] == null) { return; }
        string command = client.context_.Request.QueryString["cmd"];
        JavaScriptSerializer Serializer;
        switch(command)
        {
            case ("Add"):
                {
                    if( client.context_.Request["user"] != null )
                    {
                        client.id_ = client.context_.Request["user"];
                        Server.Add_client(client);
                    }
                    client.Set_CompletedStatus();
                    break;
                }
            case ("AddChat"):
                {
                    Server.Add_chat(client);
                    client.Set_CompletedStatus();
                    break;
                }
            case ("Remove"):
                {
                    if( client.context_.Request["user"] != null )
                    {
                        Server.RemoveClient(client.context_.Request["user"]);
                    }
                    client.Set_CompletedStatus();
                    break;
                }
            case ("RemoveChat"):
                {
                    if( client.context_.Request["user"] != null )
                    {
                        client.id_ = client.context_.Request["user"];
                        Server.Remove_chat(client);
                    }
                    client.Set_CompletedStatus();
                    break;
                }
            case ("Send"):
                {
                    Serializer = new JavaScriptSerializer();
                    Arguments args = (Arguments)Serializer.Deserialize(client.context_.Request["ARGS"], typeof(Arguments));
                    Server.Send_to(args);
                    client.Set_CompletedStatus();
                    break;
                }
            case ("Update"):
                {
                    if( client.context_.Request["user"] != null )
                    {
                        Server.Update_Clients(client, client.context_.Request["user"]);
                    }
                    break;
                }
        }
    }

    public void EndProcessRequest(IAsyncResult AR){}

    public void ProcessRequest(HttpContext context){}

    public bool IsReusable
    {
        get { return true; }
    }
}