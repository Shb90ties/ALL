using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ControlPanel___MyEventArgs___passing_Events
{
    public partial class UserControl1 : UserControl
    {
        event EventHandler<myEventArgs> myEvent;
        public UserControl1(EventHandler<myEventArgs> myEvent)
        {
            InitializeComponent();
            this.myEvent = myEvent;
        }

        private void UserControl1_Load(object sender, EventArgs e){}

        private void button1_Click(object sender, EventArgs e)
        {
            myEvent(this, new myEventArgs("Value from Button: \n"+textBox1.Text));
        }
    }
}
