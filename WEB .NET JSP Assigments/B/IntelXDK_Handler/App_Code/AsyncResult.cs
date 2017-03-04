using System;
using System.Threading;
using System.Web;

public class AsyncResult : IAsyncResult
{
    public HttpContext _context;
    public AsyncCallback _callback;
    public object _state;
    public string ClientGuid;
    private Boolean _isCompleted;

    public AsyncResult(HttpContext context, AsyncCallback callback, object data)
    {
        _context = context;
        _callback = callback;
        _state = data;
        _isCompleted = false;
        ClientGuid = "web";
    }

    public void set_Equals(AsyncResult client)
    {
        this._context = client._context;
        this._callback = client._callback;
        this._isCompleted = client._isCompleted;
        this._state = client._state;
    }

    public void set__isCompleted(bool isCompleted)
    {
        this._isCompleted = isCompleted;
    }

    public void CompleteRequest()
    {
        _isCompleted = true;
        _callback(this);
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
            return _isCompleted;
        }
    }

    public object AsyncState
    {
        get
        {
            return _state;
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