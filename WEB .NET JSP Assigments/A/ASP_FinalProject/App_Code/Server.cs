using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Web.Script.Serialization;
using System.Threading;

public class Server
{
    private static object lock_ = new object();
    private static List<AsyncResult> clients_List = new List<AsyncResult>();

    public static void Add_client(AsyncResult client)
    {
        lock (lock_)
        {
            clients_List.Add(client);
            client.context_.Response.Write("User : "+client.id_+" have successfully logged into the server");
        }
    }

    public static void Add_chat(AsyncResult chat)
    {
        lock (lock_)
        {
            chat.id_ = Guid.NewGuid().ToString();
            clients_List.Add(chat);
            chat.context_.Response.Write(chat.id_);
        }
    }

    public static void RemoveClient(string id)
    {
        lock(lock_)
        {
            AsyncResult client = clients_List.Find
                (delegate (AsyncResult cs)
                    { return (cs.id_== id); });
            if( client != null )
            {
                clients_List.Remove(client);
            }
            ChangeStatus(id);
        }
    }

    public static void Remove_chat(string id)
    {
        lock (lock_)
        {
            AsyncResult client = clients_List.Find
                (delegate (AsyncResult cs)
                    { return (cs.id_==id); });
            if( client != null )
            {
                clients_List.Remove(client);
            }
        }
    }

    public static void ChangeStatus(string user)
    {
        // go to status table
        // update row where username = user
        // change the row status to "n"
    }

    public static void Send_to(Arguments arg)
    {
        lock(lock_)
        {
            foreach(AsyncResult client in clients_List)
            {
                if( client.context_.Session != null && arg.reciever_ == client.id_ )
                {
                    client.context_.Response.Write(arg.command_+"|"+arg.sender_+"|"+arg.reciever_+"|"+arg.text_);
                    client.Set_CompletedStatus();
                }
            }
        }
    }

    public static void Update_Clients(AsyncResult current,string id)
    {
        lock(lock_)
        {
            AsyncResult client = clients_List.Find
                ( delegate (AsyncResult cs)
                { return (cs.id_ == id); } );
            if( client != null )
            {
                client.context_ = current.context_;
                client.Info_ = current.Info_;
                client.Thread_is_finished_callBack = current.Thread_is_finished_callBack;
            }
            else
            {
                current.context_.Response.Write("error|client : "+ id +" is not unregister");
                current.Set_CompletedStatus();
            }
        }
    }
}