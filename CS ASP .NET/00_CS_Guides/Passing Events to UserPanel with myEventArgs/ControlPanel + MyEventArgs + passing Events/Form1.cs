using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ControlPanel___MyEventArgs___passing_Events
{
    public partial class Form1 : Form
    {
        event EventHandler<myEventArgs> myEvent;
        public Form1()
        {
            InitializeComponent();
            myEvent += new EventHandler<myEventArgs>(myEventFunction);
            UserControl1 UC = new UserControl1(myEvent);
            this.Controls.Add(UC);
        }

        private void Form1_Load(object sender, EventArgs e){}

        public void myEventFunction(object sender,myEventArgs e)
        {
            label1.Text = e.myEventText;
        }
    }

    public class myEventArgs : EventArgs
    {
       public String myEventText { get; set; }
        public myEventArgs(String Text)
        {
            myEventText = Text;
        }
    }
}
