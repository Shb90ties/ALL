using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
// add for JS usage
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web.Security;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public partial class ChatRoom : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if( Request["sender"] == null || Request["reciever"] == null )
        {
            ClientScript.RegisterStartupScript(typeof(Page), "closePage", "window.close();", true);
            return;
        }
        HiddenField noticeSender = new HiddenField();
        noticeSender.ID = "NS";
        noticeSender.Value = "unconfirmed_chat";
        HiddenField RecieverID = new HiddenField();
        RecieverID.ID = "RI";
        RecieverID.Value = Request["reciever"];
        if ( Request["other"] != null )
        {
            noticeSender.Value = "confirmed_chat";
            HiddenField RecieverGUID = new HiddenField();
            RecieverGUID.ID = "RGI";
            RecieverGUID.Value = Request["other"];
            Form.Controls.Add(RecieverGUID);
        }
        HiddenField SenderID = new HiddenField();
        SenderID.ID = "SI";
        SenderID.Value = Request["sender"];
        Form.Controls.Add(SenderID); Form.Controls.Add(RecieverID); Form.Controls.Add(noticeSender);
        ScriptManager.RegisterStartupScript(this, this.GetType(), "void", "launch_Chat()", true);
    }
}