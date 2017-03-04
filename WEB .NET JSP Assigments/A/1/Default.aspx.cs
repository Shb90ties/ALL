using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Drawing;

public partial class _Default : System.Web.UI.Page
{
    static int r, Flag = 0, Flag1 = 0, Ready = 0;
    static String xleft, xtop;
    int rndnum;
    String gg;
    int[] buttonNumbers = new int[15];
    Button[] myButton = new Button[16];
    Button empty;
    protected void Page_Load(object sender, EventArgs e)
    {   
        int i,top=5,left=0;
        Random rnd = new Random();
        for(i=0; i<16; i++)
        {
        myButton[i] = new Button();
        myButton[i].ID = i.ToString();
        myButton[i].Click += new System.EventHandler(myButton_Click);
        UpdatePanel1.ContentTemplateContainer.Controls.Add(myButton[i]);
        labl.Text = gg;
        if (Page.IsPostBack == false)
        {
            Flag1 = 0;
            myButton[i].Width = 50;
            myButton[i].Height = 50;
            if (i != 15)
            {
                while (buttonNumbers[rndnum = rnd.Next(15)] != 0) ;
                buttonNumbers[rndnum] = 1;
                myButton[i].Text = (rndnum + 1).ToString();
            }
            myButton[i].Font.Size = new FontUnit("X-Large");
            myButton[i].BackColor = System.Drawing.Color.FromArgb(rnd.Next(255), rnd.Next(255), rnd.Next(255));
            myButton[i].Style["Position"] = "Absolute";
            myButton[i].Style["Top"] = top + "px";
            myButton[i].Style["Left"] = (left+=51) + "px";
        }
        if (i == 3 || i == 7 || i == 11)
        {
            left = 0;
            top += 51;
        }
        if (i == 15 && Flag1 == 0 )
        {
            myButton[i].Text = "15";
            myButton[i].Visible = false;
            empty = myButton[i];
            Flag1 = 1;
        }
      }
    }
    private void myButton_Click(object sender, System.EventArgs e)
    {
        r = Int32.Parse(((Button)sender).ID);
        Label L = new Label();
        L.Text = r.ToString();
        UpdatePanel1.ContentTemplateContainer.Controls.Add(L);
        if (r + 4 <= 15 && r - 4 >= 0)
        {
            if (myButton[r + 1].Visible == false || myButton[r - 1].Visible == false ||
                myButton[r + 4].Visible == false || myButton[r - 4].Visible == false)
            {
                Timer1.Interval = 1;
                Timer1.Enabled = true;
            }
        }
        else
            if(CheckPressed()==1)
            {
                Timer1.Interval = 1;
                Timer1.Enabled = true;
            }
    }

    protected void Timer1_Tick(object sender, EventArgs e)
    {
        int go = 0;
        int press = r;
        if (press + 1 <= 15 && myButton[press + 1].Visible == false && Ready == 0)   //MOVE RIGHT                             //Move Right
        {
            Ready = 1;
                if(Flag==0)
                {
                    xleft = myButton[press].Style["Left"];
                    xtop = myButton[press].Style["Top"];
                    Flag = 1;
                }
                String templeft = myButton[press].Style["Left"];
                String temptop = myButton[press].Style["Top"];
                String templeft1 = myButton[press + 1].Style["Left"];
                String temptop1 = myButton[press + 1].Style["Top"];

                int currX = templeft.LastIndexOf('p');
                currX = int.Parse(templeft.Substring(0, currX));
                myButton[press].Style["Left"] = (currX + 1).ToString() + "px";
                int counter = int.Parse(HiddenField1.Value);
                counter++;
                if (counter == 52)
                {
                    Flag = 0;
                    counter = 0;
                    myButton[press].Style["Left"] = xleft;
                    myButton[press].Style["Top"] = xtop;
                    Color c = myButton[press].BackColor; //save of pressed button
                    String num = myButton[press].Text;
                    myButton[press].BackColor = myButton[press + 1].BackColor;
                    myButton[press].Text = myButton[press + 1].Text;
                    myButton[press].Visible = false;
                    myButton[press + 1].Visible = true;
                    myButton[press + 1].BackColor = c;
                    myButton[press + 1].Text = num;
                    Timer1.Enabled = false;
                    go = 1;
                }
                HiddenField1.Value = counter.ToString();
                Ready = 0;
        }
        if (press - 1 >= 0 && myButton[press - 1].Visible == false && Ready == 0)   //MOVE LEFT                         //Move Left
        {
            Ready = 1;
            if (Flag == 0)
            {
                xleft = myButton[press].Style["Left"];
                xtop = myButton[press].Style["Top"];
                Flag = 1;
            }
            String templeft = myButton[press].Style["Left"];
            String temptop = myButton[press].Style["Top"];
            String templeft1 = myButton[press - 1].Style["Left"];
            String temptop1 = myButton[press - 1].Style["Top"];

            int currX = templeft.LastIndexOf('p');
            currX = int.Parse(templeft.Substring(0, currX));
            myButton[press].Style["Left"] = (currX - 1).ToString() + "px";
            int counter = int.Parse(HiddenField1.Value);
            counter++;
            if (counter == 52)
            {
                Flag = 0;
                counter = 0;
                myButton[press].Style["Left"] = xleft;
                myButton[press].Style["Top"] = xtop;
                Color c = myButton[press].BackColor; //save of pressed button
                String num = myButton[press].Text;
                myButton[press].BackColor = myButton[press - 1].BackColor;
                myButton[press].Text = myButton[press - 1].Text;
                myButton[press].Visible = false;
                myButton[press - 1].Visible = true;
                myButton[press - 1].BackColor = c;
                myButton[press - 1].Text = num;
                Timer1.Enabled = false;
            }
            HiddenField1.Value = counter.ToString();
            Ready = 0;
        }
        if (press + 4 <= 15 && myButton[press + 4].Visible == false && Ready == 0)  //MOVE UP                               //Move Right
         {
             Ready = 1;
             if (Flag == 0)
             {
                 xleft = myButton[press].Style["Left"];
                 xtop = myButton[press].Style["Top"];
                 Flag = 1;
             }
             String templeft = myButton[press].Style["Left"];
             String temptop = myButton[press].Style["Top"];
             String templeft1 = myButton[press + 4].Style["Left"];
             String temptop1 = myButton[press + 4].Style["Top"];

             int currX = temptop.LastIndexOf('p');
             currX = int.Parse(temptop.Substring(0, currX));
             myButton[press].Style["Top"] = (currX + 1).ToString() + "px";
             int counter = int.Parse(HiddenField1.Value);
             counter++;
             if (counter == 52)
             {
                 Flag = 0;
                 counter = 0;
                 myButton[press].Style["Left"] = xleft;
                 myButton[press].Style["Top"] = xtop;
                 Color c = myButton[press].BackColor; //save of pressed button
                 String num = myButton[press].Text;
                 myButton[press].BackColor = myButton[press + 4].BackColor;
                 myButton[press].Text = myButton[press + 4].Text;
                 myButton[press].Visible = false;
                 myButton[press + 4].Visible = true;
                 myButton[press + 4].BackColor = c;
                 myButton[press + 4].Text = num;
                 Timer1.Enabled = false;
                 go = 1;
             }
             HiddenField1.Value = counter.ToString();
             Ready = 0;
         }
        if (press - 4 >= 0 && myButton[press - 4].Visible == false && Ready == 0)  //MOVE Down                               //Move Right
        {
            Ready = 1;
            if (Flag == 0)
            {
                xleft = myButton[press].Style["Left"];
                xtop = myButton[press].Style["Top"];
                Flag = 1;
            }
            String templeft = myButton[press].Style["Left"];
            String temptop = myButton[press].Style["Top"];
            String templeft1 = myButton[press - 4].Style["Left"];
            String temptop1 = myButton[press - 4].Style["Top"];

            int currX = temptop.LastIndexOf('p');
            currX = int.Parse(temptop.Substring(0, currX));
            myButton[press].Style["Top"] = (currX - 1).ToString() + "px";
            int counter = int.Parse(HiddenField1.Value);
            counter++;
            if (counter == 52)
            {
                Flag = 0;
                counter = 0;
                myButton[press].Style["Left"] = xleft;
                myButton[press].Style["Top"] = xtop;
                Color c = myButton[press].BackColor; //save of pressed button
                String num = myButton[press].Text;
                myButton[press].BackColor = myButton[press - 4].BackColor;
                myButton[press].Text = myButton[press - 4].Text;
                myButton[press].Visible = false;
                myButton[press - 4].Visible = true;
                myButton[press - 4].BackColor = c;
                myButton[press - 4].Text = num;
                Timer1.Enabled = false;
                go = 1;
            }
            HiddenField1.Value = counter.ToString();
            Ready = 0;
         }
        if (CheckWin() == 1)
        {
            var script = "var ok = confirm('Start New Game?'); if(ok){window.location=window.location;} else{window.close();}";
            ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "messageBox", script, true);
        }
    }
    public int CheckWin()
    {
        if (myButton[0].Text == "1" && myButton[1].Text == "2")
        {
            return 1;
        }
        return 0;
    }
    public int CheckPressed()
    {
        if (r == 0)
        {
            if (myButton[1].Visible == false || myButton[4].Visible == false)
                return 1;
        }
        else if (r == 1)
        {
            if (myButton[0].Visible == false || myButton[2].Visible == false || myButton[5].Visible == false)
                return 1;
        }
        else if (r == 2)
        {
            if (myButton[1].Visible == false || myButton[3].Visible == false || myButton[6].Visible == false)
                return 1;
        }
        else if (r == 3)
        {
            if (myButton[2].Visible == false || myButton[7].Visible == false)
                return 1;
        }
        else if (r == 12)
        {
            if (myButton[8].Visible == false || myButton[13].Visible == false)
                return 1;
        }
        else if (r == 13)
        {
            if (myButton[9].Visible == false || myButton[12].Visible == false || myButton[14].Visible == false)
                return 1;
        }
        else if (r == 14)
        {
            if (myButton[13].Visible == false || myButton[10].Visible == false || myButton[15].Visible == false)
                return 1;
        }
        else if (r == 15)
        {
            if (myButton[11].Visible == false || myButton[14].Visible == false)
                return 1;
        }
        return 0;
    }
}
