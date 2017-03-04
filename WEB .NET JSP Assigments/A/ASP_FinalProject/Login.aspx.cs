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

public partial class Login : System.Web.UI.Page
{

    protected void Page_Load(object sender, EventArgs e)
    {
        string redirect = "<script>window.open('Login.aspx?PageTwo=true');</script>";
        if( Request["PageTwo"] == null )
        {
            Response.Write(redirect);
        }
    }


    protected void login_button_Click(object sender, EventArgs e)
    {
        string username = UserName_TB.Text;
        string password = Password_TB.Text;
        Response.Redirect("Check_Pages/Login_check.aspx?user=" + username + "&pass=" + password);
    }
}