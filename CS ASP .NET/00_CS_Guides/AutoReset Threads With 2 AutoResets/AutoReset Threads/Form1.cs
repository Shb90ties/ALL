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

namespace AutoReset_Threads
{
    public partial class Form1 : Form
    {
        Label[] labels;
        Panel[] panels;
        Thread[] threads = new Thread[4];
        Thread mainThread;

                            // AutoRest for Threads in threads array
        static AutoResetEvent AutoReset = new AutoResetEvent(false);
                            // AutoRest for MainThread
        static AutoResetEvent MainAutoReset = new AutoResetEvent(false);
        String MessageToMain = "null";
        public Form1() 
        {
            InitializeComponent();
            labels = new Label[] { label1, label2, label3, label4 };
            panels = new Panel[] { panel1, panel2, panel3, panel4 };
        }

        private void Form1_Load(object sender, EventArgs e){}

        public void ChangePanelAndLabel(Panel p, Color c, Label l, String s)
        {
            if (this.InvokeRequired)
            {
                this.Invoke((MethodInvoker)delegate { ChangePanelAndLabel(p, c, l, s); });
            }
            else
            {
                p.BackColor = c;
                l.Text = s;
            }
        }

        public void ChangeMainLabel(Label l, String s)
        {
            if (this.InvokeRequired)
            {
                this.Invoke((MethodInvoker)delegate { ChangeMainLabel(l, s); });
            }
            else
            {
                l.Text = s;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            mainThread = new Thread(new ThreadStart(MainThreadFunc));
            label5.Text = "Main Thread Running";
            mainThread.Start();
        }

        public void MainThreadFunc()
        {

            for(int i=0; i<threads.Length; i++)
            {
                threads[i] = new Thread(new ParameterizedThreadStart(ThreadArrayFunc));
                threads[i].Name = "Thread " + (i+1).ToString();
                threads[i].Start(i);
            }
            AutoReset.Set();
                // Sets off the first Thread that got to ThreadArrayFunc
                    // For More than one thread running
                        //  AutoReset.Set(); AutoReset.Set(); AutoReset.Set(); ..... (Must be in the same line)
            MainThreadConfirmationFunc();
        }

        public void MainThreadConfirmationFunc()
        {
            MainAutoReset.WaitOne();
            ChangeMainLabel(label5, "MainThread: "+MessageToMain);
            MainThreadConfirmationFunc();
        }

        public void ThreadArrayFunc(object myIndex)
        {
            int index = (int)myIndex;
            AutoReset.WaitOne();
                // on hold until someone put a Set command
            Random r = new Random();
            for(int i=0; i<10;i++)
            {
                Color C = Color.FromArgb(r.Next(30, 200), r.Next(30, 200), r.Next(30, 200));
                ChangePanelAndLabel(panels[index], C, labels[index], "Running");
                Thread.Sleep(100);
                ChangePanelAndLabel(panels[index], C, labels[index], Thread.CurrentThread.Name);
            }
            AutoReset.Set();
                // Sets off the next Thread that came after it
            MessageToMain = Thread.CurrentThread.Name + " Done!";
                // Sets off main thread that is waiting for confirmation MainThreadConfirmationFunc
            MainAutoReset.Set();
            ThreadArrayFunc(myIndex);
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            for(int i=0; i<threads.Length; i++)
            {
                threads[i].Abort();
            }
            mainThread.Abort();
        }
    }
}
