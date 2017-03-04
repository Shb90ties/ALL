using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Drawing;
using System.Data;
using System.Configuration;

using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

[Serializable]
public class Arguments
{
    public string HTMLcolorCode;
    public string num;

    public Arguments()
    {
        this.num = "0";
        this.HTMLcolorCode = "#ffffff";
    }
    public Arguments(string number,string colorCode)
    {
        this.num = number;
        this.HTMLcolorCode = colorCode;
    }

    public void Equals_(Arguments arg)
    {
        this.num = arg.num;
        this.HTMLcolorCode = arg.HTMLcolorCode;
    }
}