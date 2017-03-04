using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    private Button[] arrButtons;
    protected void Page_Load(object sender, EventArgs e)
    {
        arrButtons = new Button[15];
        for (int i = 0; i < 15; i++)
        {
            arrButtons[i] = new Button();
            arrButtons[i].ID = i.ToString();
            form1.Controls.Add(arrButtons[i]);
            arrButtons[i].Attributes.Add("onclick", "javascript:myClick(this);return false;");
        }
        if (Page.IsPostBack == false)
        {
            for (int i = 0; i < 15; i++)
            {
                arrButtons[i].Width = 70;
                arrButtons[i].Height = 70;
                arrButtons[i].Font.Size = new FontUnit("X-Large");
                arrButtons[i].TabIndex = (short)i;
                int left = 1 + (i % 4) * 70;
                int top = 35 + (i / 4) * 70;
                arrButtons[i].Style["Position"] = "Absolute";
                arrButtons[i].Style["Top"] = top.ToString() + "px";
                arrButtons[i].Style["Left"] = left.ToString() + "px";
            }
        }
    }
}