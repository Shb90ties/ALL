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

public partial class Check_Pages_Singup_Check : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if( Request["user"] != null && Request["pass"] != null )
        {                           // cannot be equals to "end" +(ignore capslock)
            if( !Request["user"].Equals("end",StringComparison.InvariantCultureIgnoreCase) &&
                    Request["user"].Trim() != "" && Request["pass"].Trim() != "" &&
                      !UserName_exists(Request["user"]) )
            {
                if(Add_newUSER(Request["user"],Request["pass"]) && !illegal_chars(Request["user"]))
                {
                    Response.Redirect("../MyPage.aspx?user=" + Request["user"]);
                }
            }
        }
    }

    protected bool illegal_chars(string username)
    {
        char[] temp = username.ToArray();
        foreach(char i in temp)
        {
            if( i == '|' )
            { return true; }
        }
        if( temp.Length >= 20) { return true; }
        return false;
    }

    protected bool UserName_exists(string username)
    {
            // TEST accounts
        if( username == "abc" || username == "xox" || username == "ttc")
        {
            return true;
        }
            // TEST accounts

                // open status table
                // check if username exists
                // if it exists return true;  so it won't create another one
        return false;
    }

    protected bool Add_newUSER(string username,string password)
    {
            // open status table
            // add row to status table
            // username = username, password = password , status = "y"
        return true;
    }
}