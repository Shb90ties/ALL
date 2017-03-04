using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Ass3 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (IsPostBack)
        {
            ClientScript.RegisterStartupScript(typeof(Page), "",
                "<script>installation()</script>");
        }
        else
        {
            ClientScript.RegisterStartupScript(typeof(Page), "",
                "<script>build()</script>");
        }
    }
}