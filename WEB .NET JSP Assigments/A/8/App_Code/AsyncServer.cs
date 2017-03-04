using System;
using System.Collections.Generic;

using System.Web.Script.Serialization;

public class AsyncServer
{
    //public static void load(AsyncResult state)
    //{
    //    Fraction[] arrFraction = new Fraction[2];
    //    for (int i = 0; i < 2; i++)
    //        arrFraction[i] = new Fraction(0, 1);

    //    JavaScriptSerializer myJavaScriptSerializer = new JavaScriptSerializer();
    //    string resultStr = myJavaScriptSerializer.Serialize(arrFraction);
    //    state._context.Response.Write(resultStr);
    //}

    //public static void PlusMinus(AsyncResult state, Fraction A, Fraction B)
    //{
    //    Fraction[] arrFraction = new Fraction[2];
    //    arrFraction[0] = A + B;
    //    arrFraction[1] = A - B;

    //    JavaScriptSerializer myJavaScriptSerializer = new JavaScriptSerializer();
    //    string resultStr = myJavaScriptSerializer.Serialize(arrFraction);
    //    state._context.Response.Write(resultStr);
    //}

    public static void initTextAndColor(AsyncResult state)
    {
        TextAndColor[] tac = new TextAndColor[16];
        Random r = new Random();
        System.Drawing.Color tmp;
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++)
        {
            arr[i] = i + 1;
        }
        int k = 15, n;
        for (int i = 0; i < 15; i++)
        {
            tmp = System.Drawing.Color.FromArgb(r.Next(206) + 50, r.Next(206) + 50, r.Next(206) + 50);
            n = r.Next(k) + 1;
            tac[i] = new TextAndColor(arr[n - 1].ToString(), System.Drawing.ColorTranslator.ToHtml(tmp));
            arr[n - 1] = arr[k - 1];
            k--;
        }
        tac[15] = new TextAndColor("-1", "-1");

        JavaScriptSerializer myJavaScriptSerializer = new JavaScriptSerializer();
        string resultStr = myJavaScriptSerializer.Serialize(tac);
        state._context.Response.Write(resultStr);
    }
    public static void TextAndColorChange(AsyncResult state, TextAndColor[] tac, string txt1)
    {
        int IndexEmpty = -1, IndexTxt = -1;
        for (int i = 0; i < 16; i++)
        {
            if (tac[i].texttt == "-1")
            {
                IndexEmpty = i;
            }
            if (tac[i].texttt == txt1)
            {
                IndexTxt = i;
            }
        }
        tac[IndexEmpty].texttt = tac[IndexTxt].texttt;
        tac[IndexEmpty].strHtmlColor = tac[IndexTxt].strHtmlColor;
        tac[IndexTxt].texttt = "-1";
        tac[IndexTxt].strHtmlColor = "-1";
        JavaScriptSerializer myJavaScriptSerializer = new JavaScriptSerializer();
        string resultStr = myJavaScriptSerializer.Serialize(tac);
        state._context.Response.Write(resultStr);
    }

    public static void bgc(AsyncResult state,TextAndColor button, TextAndColor bg)
    {
        string s1 = button.strHtmlColor;
        string s2 = bg.strHtmlColor;
        System.Drawing.Color c = System.Drawing.ColorTranslator.FromHtml(s1);
        System.Drawing.Color c2 = System.Drawing.ColorTranslator.FromHtml(s2);
        System.Drawing.Color newcolor = System.Drawing.Color.FromArgb((c.R + c2.R) / 2, (c.G + c2.G) / 2, (c.B + c2.B) / 2);
        String NewHtmlColor = System.Drawing.ColorTranslator.ToHtml(newcolor);
        JavaScriptSerializer myJavaScriptSerializer = new JavaScriptSerializer();
        string resultStr = myJavaScriptSerializer.Serialize(NewHtmlColor);
        state._context.Response.Write(resultStr);       
    }
    public static void endgame(AsyncResult state,TextAndColor[] tac)
    {
        int flag=0;
        if (tac[0].texttt == "1")
            if (tac[1].texttt == "2")
                flag= 1;
        
        JavaScriptSerializer myJavaScriptSerializer = new JavaScriptSerializer();
        string resultStr = myJavaScriptSerializer.Serialize(flag);
        state._context.Response.Write(resultStr); 

    }

}
