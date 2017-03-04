using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

using Common;

using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Http;

namespace Server
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            HttpChannel myChannel = new HttpChannel(1234);
            ChannelServices.RegisterChannel(myChannel , false);
            RemotingConfiguration.RegisterWellKnownServiceType(typeof(myServer), "myServerName", WellKnownObjectMode.SingleCall);
        }
        private void Form1_Load(object sender, EventArgs e){}

        public class myServer : MarshalByRefObject, CommonMethods
        {
            public MyCommon showText(string Text)
            {
                MyCommon temp = new MyCommon();
                temp.Text = "Message from server to Request "+Text;
                return temp;
            }
        }
    }
}
