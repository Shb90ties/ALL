using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Drawing;
using System.Web.Services;

public partial class WebAssigment_2 : System.Web.UI.Page
{
    Button[] table_buttons;
    Random random_;
    int[] table_numbers;
    protected void Page_Load(object sender, EventArgs e)
    {
        table_buttons = new Button[16];
        random_ = new Random(); 
        start_game();
        quick.BorderColor = Color.Black;
        quick.BorderStyle = BorderStyle.Groove;
    }

    public void start_game()
    {
        for(int i=0; i<16; i++)
        {
            table_buttons[i] = new Button();
            table_buttons[i].Click += new EventHandler(Click_);
            String number = (i + 1).ToString();
            table_buttons[i].ID = number;
            table_buttons[i].BorderColor = Color.Black;
            table_buttons[i].BorderWidth = 2;
        }
        for (int i = 0; i < 4; i++ )
        {
            TableRow row = new TableRow();
            for(int j=0; j < 4;j++)
            {
                TableCell cell = new TableCell();
                cell.Controls.Add(table_buttons[i * 4 + j]);
                row.Controls.Add(cell);
            }
            table_.Controls.Add(row);
        }
        if (IsPostBack == false)
        {
            new_load();
        }
    }

    protected void new_load()
    {
        int r,g,b;
        table_numbers = new int[15];
        for(int i=0; i<16; i++)
        {
            table_buttons[i].Width = 60;
            table_buttons[i].Height = 30;
            r = random_.Next(255);
            g = random_.Next(255);
            b = random_.Next(255);
            table_buttons[i].BackColor = Color.FromArgb(r, g, b);
            if( i == 15 )
            {
                table_buttons[i].Text = "16";
                table_buttons[i].Visible = false;
            }
            else
            {
                int temp;
                while (table_numbers[temp = random_.Next(15)] != 0) ;
                table_numbers[temp] = 1;
                table_buttons[i].Text = (temp + 1).ToString();
            }
        }
    }
    protected void Fast_counting(object sender, System.EventArgs e)
    {
        Winner(true);
    }

    protected void Click_(object sender, System.EventArgs e)
    {
        int click = int.Parse(((Button)sender).ID) - 1;
        string temp = "";
        Color temp_color = Color.White;
        int already_clicked = 0;
        if (click - 1 >= 0 && already_clicked == 0)
        {
            if( table_buttons[click-1].Visible == false )
            {
                if( IsPostBack == true)
                {
                    temp = table_buttons[click - 1].Text;
                    temp_color = table_buttons[click - 1].BackColor;
                    table_buttons[click - 1].Text = table_buttons[click].Text;
                    table_buttons[click - 1].BackColor = table_buttons[click].BackColor;
                    table_buttons[click].Text = temp;
                    table_buttons[click].BackColor = temp_color;
                    table_buttons[click - 1].Visible = true;
                    table_buttons[click].Visible = false;
                    already_clicked = 1;
                }
            }
        }

        if (click + 1 <= 15 && already_clicked == 0)
        {
            if (table_buttons[click + 1].Visible == false)
            {
                if (IsPostBack == true)
                {
                    temp = table_buttons[click + 1].Text;
                    temp_color = table_buttons[click + 1].BackColor;
                    table_buttons[click + 1].Text = table_buttons[click].Text;
                    table_buttons[click + 1].BackColor = table_buttons[click].BackColor;
                    table_buttons[click].Text = temp;
                    table_buttons[click].BackColor = temp_color;
                    table_buttons[click + 1].Visible = true;
                    table_buttons[click].Visible = false;
                    already_clicked = 1;
                }
            }
        }

        if (click - 4 >= 0 && already_clicked == 0)
        {
            if (table_buttons[click - 4].Visible == false)
            {
                if (IsPostBack == true)
                {
                    temp = table_buttons[click - 4].Text;
                    temp_color = table_buttons[click - 4].BackColor;
                    table_buttons[click - 4].Text = table_buttons[click].Text;
                    table_buttons[click - 4].BackColor = table_buttons[click].BackColor;
                    table_buttons[click].Text = temp;
                    table_buttons[click].BackColor = temp_color;
                    table_buttons[click - 4].Visible = true;
                    table_buttons[click].Visible = false;
                    already_clicked = 1;
                }
            }
        }

        if (click + 4 <= 15 && already_clicked == 0)
        {
            if (table_buttons[click + 4].Visible == false)
            {
                if (IsPostBack == true)
                {
                    temp = table_buttons[click + 4].Text;
                    temp_color = table_buttons[click + 4].BackColor;
                    table_buttons[click + 4].Text = table_buttons[click].Text;
                    table_buttons[click + 4].BackColor = table_buttons[click].BackColor;
                    table_buttons[click].Text = temp;
                    table_buttons[click].BackColor = temp_color;
                    table_buttons[click + 4].Visible = true;
                    table_buttons[click].Visible = false;
                    already_clicked = 1;
                }
            }
        }

        Winner(false);
    }

    protected void Winner(Boolean quick_check)
    {
        if( quick_check )
        {
            if( table_buttons[0].Text == "1" && table_buttons[1].Text == "2")
            {
                show_message();
            }
            
        }
        else
        {
            Boolean win = true;
            for (int i = 0; i < 14; i++)
            {
                if( !table_buttons[i].Text.Equals((i+1).ToString()))
                {
                    win = false;
                }
            }
            if( win )
            {
                show_message();
            }
        }
    }

    protected void show_message()
    {
        var s = "var ok = confirm('new game??'); if(ok){window.location = window.location;}else{window.close();}";
        ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "message", s, true);
    }

}