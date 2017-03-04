using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Common
{
    public interface CommonMethods
    {
        MyCommon showText(string text);
    }
    [Serializable]
    public class MyCommon
    {
        public MyCommon()
        {
            this.Text = "null";
        }
        public String Text { get; set; }
    }
}
