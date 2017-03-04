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

public partial class Check_Pages_Login_check : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Request["user"] != null && Request["pass"] != null)
        {
            string userN = Request["user"]; string pass = Request["pass"];
            if ( CheckUserName(userN) && CheckPassword(userN,pass) )
            {
                Response.Redirect("../MyPage.aspx?user="+userN);
            }
        }
    }

    protected bool CheckUserName(string username)
    {
            // TEST accounts 
        if(username == "abc" || username == "ttc" || username == "xox")
        {
            return true;
        }
            // TEST accounts


                // go to Status Table
                // check if username exists
                // check if username status = "n" , he is not logged on
                // if username is NOT logged on, status = "n" return true;
                // else return false; can't log on twice
                //      ^ if all correct return true;
        return false;
    }

    protected bool CheckPassword(string username,string password)
    {
            // TEST account
        if (password == "123")
        {
            return true;
        }
            // TEST account

                // go to status table
                // check if the password on this username is correct
                // return true is its correct
        return false;
    }
}