using System;
using System.Threading;
using System.Web;

using System.Collections.Generic;
using System.Linq;

public class AsyncResult : IAsyncResult
{
    public HttpContext context_;
    public AsyncCallback Thread_is_finished_callBack;
    public object Info_;
    //public string ClientGUID;
    public string id_;
    private Boolean completed;
    public AsyncResult(HttpContext context,AsyncCallback callback,object data)
    {
        context_ = context;
        Thread_is_finished_callBack = callback;
        Info_ = data;
        completed = false;
    }

    public void Set_userID(string id)
    {
        this.id_ = id;
    }

    public void Set_CompletedStatus()
    {
        completed = true;
        Thread_is_finished_callBack(this);
    }
    public Boolean CompletedSynchronously
    {
        get
        {
            return false;
        }
    }
    public bool IsCompleted
    {
        get
        {
            return completed;
        }
    }
    public object AsyncState
    {
        get
        {
            return Info_;
        }
    }
    public WaitHandle AsyncWaitHandle
    {
        get
        {
            return new ManualResetEvent(false);
        }
    }
}