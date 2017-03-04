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
using System.Drawing;
using System.Web.Services;

public partial class MyPage : System.Web.UI.Page
{
    protected List<HiddenField> friendList;
    protected HiddenField userName;
    protected HiddenField Add_Delete;
    protected string myUsername;
    protected void Page_Load(object sender, EventArgs e)
    {
        friendList = new List<HiddenField>();
        if( Request["user"] == null ) { Response.Redirect("Login.aspx");    return; }
        if( Request["user"].Trim() == "" ) { Response.Redirect("Login.aspx"); return; }
        Add_Delete = new HiddenField();
        Add_Delete.ID = "Add_Delete";
        Add_Delete.Value = "null";
        if( Request["Add_User"] != null ) { Add_toMy_Contacts(Request["Add_User"]); }
        if( Request["Remove_User"] != null ) { Remove_fromMy_Contacts(Request["Remove_User"]); }
        userName = new HiddenField();
        userName.ID = "UN";
        userName.Value = Request["user"];
        get_FriendList(Request["user"]);
        foreach(HiddenField i in friendList)
        {
            Form.Controls.Add(i);
        }
        Form.Controls.Add(userName);
        Form.Controls.Add(Add_Delete);
        myUsername = userName.Value;
        update_MyStatus();
        ScriptManager.RegisterStartupScript(this, this.GetType(), "void", "insert_Username()", true);
    }

    protected void Add_toMy_Contacts(string user)
    {
        if (user_Exists(Request["Add_User"]) &&
            !Request["Add_User"].Equals(Request["user"], StringComparison.InvariantCultureIgnoreCase))
        {
            add_contact(Request["Add_User"]);
            Add_Delete.Value = "User " + Request["Add_User"] + " was Add to your list";
            return;
        }
        Add_Delete.Value = "An error occurred user " + Request["Add_User"] + " was not Added to your list \nEither user doesn't exists or there's a problem with the database\nYou cannot add a user with the same username as you";
    }

    protected void Remove_fromMy_Contacts(string user)
    {
        if(user_Exists(Request["Remove_User"]) &&
            !Request["Remove_User"].Equals(Request["user"], StringComparison.InvariantCultureIgnoreCase))
        {
            remove_contact(Request["Remove_User"]);
            Add_Delete.Value = "User " + Request["Remove_User"] + " was removed to your list";
            return;
        }
        Add_Delete.Value = "An error occurred user " + Request["Remove_User"] + " was not removed to your list \nEither user is not on your list or there's a problem with the database\nYou cannot remove a user with the same username as you";
    }

    protected void get_FriendList(string username)
    {
        int counter = 0;
        List<string> temp = get_Flist(username);
        foreach(string s in temp)
        {
            HiddenField j = new HiddenField();
            j.ID = counter.ToString();
            counter++;
            j.Value = s;
            friendList.Add(j);
        }
        HiddenField endMark = new HiddenField();
        endMark.ID = counter.ToString();
        endMark.Value = "end";
        friendList.Add(endMark);
    }

    public List<string> get_Flist(string user)
    {
        List<string> temp = new List<string>();
        // go to contact table and get all the rows where username = user ^
        // get all the contacts names from those rows
        // foreach contact check in status table if contact is logged on
        // if logg on status = "y" => temp.add(the contact)


            // for TEST accounts
            temp.Add("xox");
            temp.Add("ttc");
            temp.Add("123");
            // for TEST accounts

        return temp;
    }

    public void add_contact(string contact)
    {           // protected string :: myUsername above^ already defined on pageload
        // go to contacts table
        // add row, username = myUsername , contactname = contact (given value)
    }

    public void remove_contact(string contact)
    {
        // go to contacts table
        // remove row, username = myUsername , contactname = contact (given value)
    }
    protected bool user_Exists(string user)
    {
        // go to status table
        // check if the user ^ exists in it, status is irrelevant
        // if there's a username with that name return true;

        // for TEST accounts
        if (user == "abc" || user == "xox" || user == "ttc") { return true; }
        // for Test accounts
        return false;
    }

    protected void update_MyStatus()
    {
        // go to status table
        // update row where username == myUsername
        //      update row to status = "y"
    }
}