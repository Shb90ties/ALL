using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Drawing;
using System.Data;
using System.Configuration;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

[Serializable]
public class Arguments
{
    public string command_;
    public string sender_;
    public string reciever_;
    public string text_;
    public Arguments()
    {
        this.command_ = this.sender_ = this.reciever_ = this.text_ = "null";
    }

    public Arguments(string command,string sender,string reciever,string text,string guID)
    {
        command_ = command;
        sender_ = sender;
        reciever_ = reciever;
        text_ = text;
    }
}