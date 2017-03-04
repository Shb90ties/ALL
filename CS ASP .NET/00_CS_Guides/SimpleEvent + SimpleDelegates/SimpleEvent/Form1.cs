using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
        // Make a delegate for functions with wanted return value and insert virables
        // Make an Event Class
        // Make a function that fits the delegate, here example myFunctionA & myFunctionB(with more virables)
        // in Form make a new Event class object, fit the function to the myEvent in the object 

namespace SimpleEvent
{
        // will fit a function that returns void and gets string into the event
    public delegate void myEventFunction(string Text);

    public partial class Form1 : Form
    {
        public myEventClass theEvent;
        public Form1()
        {
            InitializeComponent();

            theEvent = new myEventClass();
            theEvent.myEvent += new myEventFunction(myFunctionA);
                // a way of inserting more virables than originally intended
            theEvent.myEvent += delegate(string Text) { myFunctionB(Text, "\n Another virable"); };
        }

        private void Form1_Load(object sender, EventArgs e){}

        private void button1_Click(object sender, EventArgs e)
        {
            theEvent.Trigger = "triggering the event!!";
        }

        public void myFunctionA(string Text)
        {
            label1.Text = "Event Launched FunctionA";
        }

        public void myFunctionB(string Text,string moreText)
        {
            label2.Text = "Second Function that also got " + moreText;
        }
    }
    public class myEventClass
    {
        private string TriggerValue;
        public event myEventFunction myEvent;

        public string Trigger
        {   // class.Trigger = something, will launch what ever was add to myEvent
            set 
            {
                this.TriggerValue = value;
                this.myEvent(TriggerValue);
            }
        }
    }
}
