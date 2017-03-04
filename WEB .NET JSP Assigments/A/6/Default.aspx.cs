using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Configuration;
using System.Web.Security;
using System.Web.UI.HtmlControls;
using System.Drawing;
using System.Web.Services;


public partial class _Default : System.Web.UI.Page
{
    protected HiddenField[] number_fields;
    protected Button[] Buttons_array;
    protected HiddenField[] serverClient;
    Random rand;
    int[] numbers;
    protected Button empty;
    protected void Page_Load(object sender, EventArgs e)
    {
        rand = new Random();
        Buttons_array = new Button[16];
            // install hiddenFields Id's and buttons Id's 0~15
        for (int i = 0; i < 16; i++)
        {
            Buttons_array[i] = new Button();
            Buttons_array[i].ID = i.ToString() + 'b';
            Buttons_array[i].Text = i.ToString();
            form1.Controls.Add(Buttons_array[i]);
        }
            // if new visit => shuffle
        if (!Page.IsPostBack) { new_load(); }
        else { update_HFs(); update_client_buttons(); }
        foreach(Button i in Buttons_array)
        {
            if(i.Font.Size == 28)
            {
                i.Click += new EventHandler(server_click);
            }
        }
        ScriptManager.RegisterStartupScript(this.Page, Page.GetType(), "text", "install_position()", true);
    }
    protected void new_load()
    {
        numbers = new int[16];
        make_HFs();
        for (int i = 0; i < 16; i++)
        {
            Buttons_array[i].Width = Buttons_array[i].Height = 60;
            Buttons_array[i].BackColor = Color.FromArgb(rand.Next(255), rand.Next(255), rand.Next(255));
            number_fields[i].Value = "0";
            serverClient[i].Value = "client";
            if (i == 15) { Buttons_array[i].Text = "16"; number_fields[i].Value = "16"; }
            else
            {
                int temp;
                while (numbers[temp = rand.Next(15)] != 0) ;
                numbers[temp] = 1;
                Buttons_array[i].Text = (temp + 1).ToString();
            }
        }
        make_server_buttons();
        rest_HF();
    }
    protected void make_HFs()
    {
        number_fields = new HiddenField[16];
        serverClient = new HiddenField[16];
        for (int i = 0; i < 16; i++)
        {
            number_fields[i] = new HiddenField();
            number_fields[i].ID = i.ToString() + 'f';
            serverClient[i] = new HiddenField();
            serverClient[i].ID = i.ToString() + 't';
            form1.Controls.Add(number_fields[i]);
            form1.Controls.Add(serverClient[i]);
        }
    }
    protected void update_HFs()
    {
        number_fields = new HiddenField[16];
        serverClient = new HiddenField[16];
        for (int i = 0; i < 16; i++)
        {
            HiddenField number = new HiddenField();
            number.ID = i.ToString() + 'f';
            HiddenField clientServer = new HiddenField();
            clientServer.ID = i.ToString() + 't';
            number.Value = (string)(Request.Form[number.ID]);
            clientServer.Value = (string)(Request.Form[clientServer.ID]);
            number_fields[i] = number;
            serverClient[i] = clientServer;
            form1.Controls.Add(number);
            form1.Controls.Add(clientServer);
        }
    }
    protected void make_server_buttons()
    {
        int counter = 0;
        while(counter < 8)
        {
            int i = 0;
            while (number_fields[i = rand.Next(16)].Value != "0");
            number_fields[i].Value = Buttons_array[i].Text;
            serverClient[i].Value = "server";
            Buttons_array[i].Font.Size = 28;
            Buttons_array[i].Click += new EventHandler(server_click);
            counter++;
        }
    }
    protected void rest_HF()
    {
        for(int i=0; i<16; i++)
        {
            if( serverClient[i].Value.Equals("client") )
            {
                number_fields[i].Value = Buttons_array[i].Text;
            }
        }
    }
    protected Button get_button(string val)
    {
        for(int i=0; i<16; i++)
        {
            if( Buttons_array[i].Text.Equals(val) )
            {
                return Buttons_array[i];
            }
        }
        return null;
    }
    protected void swap_buttonds(Button a,Button b)
    {
        Button temp = new Button();
        temp.BackColor = a.BackColor;
        temp.Text = a.Text;
        temp.Font.Size = a.Font.Size;
        a.BackColor = b.BackColor;
        a.Text = b.Text;
        a.Font.Size = b.Font.Size;
        b.BackColor = temp.BackColor;
        b.Text = temp.Text;
        b.Font.Size = temp.Font.Size;
    }
    protected void update_client_buttons()
    {
        for(int i=0; i<16;i++)
        {
            if( !number_fields[i].Value.Equals(Buttons_array[i].Text) )
            {
                Button b = get_button(number_fields[i].Value);
                swap_buttonds(Buttons_array[i],b);
            }
        }
    }
    protected void server_click(object sender, EventArgs e)
    {
        Button sender_ = ((Button)sender);
        string resultString = System.Text.RegularExpressions.Regex.Match(sender_.ID, @"\d+").Value; int my_index = int.Parse(resultString);
        int empty_index = get_empty_index(my_index);
        if( empty_index != (-1) )
        {
            string temp = number_fields[my_index].Value;
            number_fields[my_index].Value = number_fields[empty_index].Value;
            number_fields[empty_index].Value = temp;
            temp = serverClient[my_index].Value;
            serverClient[my_index].Value = serverClient[empty_index].Value;
            serverClient[empty_index].Value = temp;
            swap_buttonds(Buttons_array[my_index], Buttons_array[empty_index]);
        }
        update_HFs_after_click();
        check_win();
    }
    protected void update_HFs_after_click()
    {
        for(int i=0; i<16;i++)
        {
            form1.Controls.Add(number_fields[i]);
            form1.Controls.Add(serverClient[i]);
        }
    }
    protected int get_empty_index(int index) // return -1 if not near empty spot
    {
        if( (index+1) < 16 )
        {
            if (number_fields[index + 1].Value.Equals("16")) { return (index + 1); }
        }
        if( (index-1) >= 0 )
        {
            if (number_fields[index - 1].Value.Equals("16")) { return (index - 1); }
        }
        if( (index+4) < 16 )
        {
            if (number_fields[index + 4].Value.Equals("16")) { return (index + 4); }
        }
        if( (index-4) >= 0)
        {
            if (number_fields[index - 4].Value.Equals("16")) { return (index - 4); }
        }
        return -1;
    }
    protected void check_win()
    {
        if( number_fields[0].Value.Equals("1") && number_fields[1].Value.Equals("2") )
        {
            new_game_message();
        }
    }

    public void new_game_message()
    {
        var messg = "var ok = confirm('start a new game?'); if(ok){window.location = window.location;}else{window.close();}";
        ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "message", messg, true);
    }

}