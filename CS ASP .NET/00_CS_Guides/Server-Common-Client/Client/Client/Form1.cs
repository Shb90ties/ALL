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

namespace Client
{
    public partial class Form1 : Form
    {
        CommonMethods myCommonServer;
        public Form1()
        {
            InitializeComponent();

            HttpChannel myChannel = new HttpChannel();
            ChannelServices.RegisterChannel(myChannel, false);
            myCommonServer = (CommonMethods)Activator.GetObject(typeof(CommonMethods), "http://localhost:1234/myServerName");
        }

        private void Form1_Load(object sender, EventArgs e){}

        private void button1_Click(object sender, EventArgs e)
        {
            try 
            {
                MyCommon temp = myCommonServer.showText(textBox1.Text);
                label1.Text = temp.Text;
            }
            catch
            {
                label1.Text = "can't reach server";
            }
            
        }


    }
}
