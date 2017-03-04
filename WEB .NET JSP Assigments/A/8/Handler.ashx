<%@ WebHandler Language="C#" Class="Handler" %>

using System;
using System.Web;
using System.Threading;

using System.Web.Script.Serialization;
class Handler : IHttpAsyncHandler
{
    public Handler()
    {
    }
    public IAsyncResult BeginProcessRequest(HttpContext ctx, AsyncCallback cb, Object obj)
    {
        AsyncResult currentAsyncState = new AsyncResult(ctx, cb, obj);
        ThreadPool.QueueUserWorkItem(new WaitCallback(RequestWorker), currentAsyncState);
        return currentAsyncState;
    }    
    private void RequestWorker(Object obj)
    {
       
        // obj - second parametr in ThreadPool.QueueUserWorkItem()
        AsyncResult myAsyncResult = obj as AsyncResult;
        myAsyncResult._context.Response.ContentType = "application/x-www-form-urlencoded";
        string command = myAsyncResult._context.Request["cmd"];
        JavaScriptSerializer myJavaScriptSerializer;
        switch (command)
        {            
            case "TextAndColorInit":
                AsyncServer.initTextAndColor(myAsyncResult);
                break;
            case "TextAndColorChange":
                string JsonString1 = "", JsonString2 = "";
                if (myAsyncResult._context.Request["JSON_Object_0"] != null)
                    JsonString1 = myAsyncResult._context.Request["JSON_Object_0"];
                if (myAsyncResult._context.Request["JSON_Object_1"] != null)
                    JsonString2 = myAsyncResult._context.Request["JSON_Object_1"];

                myJavaScriptSerializer = new JavaScriptSerializer();           
                TextAndColor[] A= (TextAndColor[])myJavaScriptSerializer.Deserialize(JsonString1, typeof(TextAndColor[]));
                string str = (string)myJavaScriptSerializer.Deserialize(JsonString2, typeof(string));
                AsyncServer.TextAndColorChange(myAsyncResult,A, str);
                break;
            case "bgc":
                 string JsonString11 = "", JsonString22 = "";
                if (myAsyncResult._context.Request["JSON_Object_2"] != null)
                    JsonString11 = myAsyncResult._context.Request["JSON_Object_2"];
                if (myAsyncResult._context.Request["JSON_Object_3"] != null)
                    JsonString22 = myAsyncResult._context.Request["JSON_Object_3"];

                myJavaScriptSerializer = new JavaScriptSerializer();           
                TextAndColor a = (TextAndColor)myJavaScriptSerializer.Deserialize(JsonString11, typeof(TextAndColor));
                TextAndColor b = (TextAndColor)myJavaScriptSerializer.Deserialize(JsonString22, typeof(TextAndColor));
                AsyncServer.bgc(myAsyncResult,a, b);                
                break;
            case "endgame":
                string JsonString = "";
                if (myAsyncResult._context.Request["JSON_Object_e"] != null)
                    JsonString = myAsyncResult._context.Request["JSON_Object_e"];              

                myJavaScriptSerializer = new JavaScriptSerializer();
                TextAndColor[] eg = (TextAndColor[])myJavaScriptSerializer.Deserialize(JsonString, typeof(TextAndColor[]));
                AsyncServer.endgame(myAsyncResult, eg);
                break;
        }
        myAsyncResult.CompleteRequest(); 
    }

    public void EndProcessRequest(IAsyncResult ar)
    {
    }

    public bool IsReusable
    {
        get { return true; }
    }

    public void ProcessRequest(HttpContext context)
    {
    }
}