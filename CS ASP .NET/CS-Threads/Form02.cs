using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Threading;
using System.Threading.Tasks;
using System.Timers;

namespace Threads
{
    public partial class Form1 : Form
    {
        List<Panel> Panles;
        List<Thread> myThreads;
        public Form1()
        {
            InitializeComponent();
            Panles = new List<Panel>();
            Panles.Add(panel1); Panles.Add(panel2); Panles.Add(panel3); Panles.Add(panel4);
            myThreads = new List<Thread>();
        }

        private void Form1_Load(object sender, EventArgs e){}
        
        //only Main Thread can change Form.controls others need Invoke
        public void ChangePanelAndLabel(Panel p,Color c,String ThreadName)
        {
            if( this.InvokeRequired )
            {
                this.Invoke((MethodInvoker)delegate { ChangePanelAndLabel(p, c, ThreadName); });
            }
            else
            {
                p.BackColor = c;
                label1.Text = ThreadName;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Thread a = new Thread(new ParameterizedThreadStart(ThreadFunction));
            Thread b = new Thread(new ParameterizedThreadStart(ThreadFunction));
            myThreads.Add(a); myThreads.Add(b); 
            a.Start(Color.Blue);
            a.Name = "Thread A running";
            b.Start(Color.Red);
            b.Name = "Thread B running";
        }

        public void ThreadFunction(object colorOBJ)
        {
            lock(this)
            {
                Color ThreadColor = (Color)colorOBJ;
                foreach(Panel p in Panles)
                {
                    ChangePanelAndLabel(p, ThreadColor, Thread.CurrentThread.Name);
                    Thread.Sleep(500);
                }
                if( Thread.CurrentThread.Name == "Thread B running" )
                {
                    foreach(Thread t in myThreads)
                    { t.Abort(); }
                }
            }
        }
    }
}
