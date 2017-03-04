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
/// <summary>
/// Summary description for TextAndColor
/// </summary>
///
[Serializable]
public class TextAndColor
{
    public string texttt;
    public string strHtmlColor;
    public TextAndColor()
    {
        this.texttt = "0";
        this.strHtmlColor = "0";
    }
    public TextAndColor(string t, string c)
    {
        this.texttt = t;
        this.strHtmlColor = c;
    }
}