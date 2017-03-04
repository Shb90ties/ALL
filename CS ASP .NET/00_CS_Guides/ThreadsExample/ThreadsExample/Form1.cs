using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
    // Add
using System.Threading.Tasks;
using System.Threading;
using System.Timers;

namespace ThreadsExample
{
    public partial class Form1 : Form
    {
        Thread From;
        AutoResetEvent FromReset = new AutoResetEvent(false);

        Thread Transport;
        AutoResetEvent TransportReset = new AutoResetEvent(false);

        Thread To;
        AutoResetEvent ToReset = new AutoResetEvent(false);

        public Form1()
        {
            InitializeComponent();
        }

        Random rand = new Random();
        public void changePanelColor(Panel p)
        {
            if (this.InvokeRequired)
            {
                this.Invoke((MethodInvoker)delegate { changePanelColor(p); });
            }
            else
            {
                Color temp = Color.FromArgb(rand.Next(200), rand.Next(200), rand.Next(200));
                p.BackColor = temp;
            }
        }

        private void Form1_Load(object sender, EventArgs e){}

        private void button1_Click(object sender, EventArgs e)
        {
            From = new Thread(new ParameterizedThreadStart(FromThreadMethod));
            From.Start(1);

            Transport = new Thread(new ParameterizedThreadStart(TransportThreadMethod));
            Transport.Start(2);

            To = new Thread(new ParameterizedThreadStart(ToThreadMethod));
            To.Start(3);
        }

        int FromTimes = 0;
        public void FromThreadMethod(object something)
        {
            // int id = (int)something; , when working with Thread[]
            if (FromTimes > 30) { FromTimes = 0; TransportReset.Set(); FromReset.WaitOne(); }
            changePanelColor(panel1);
            FromTimes++;
            Thread.Sleep(50);
            FromThreadMethod(something);
        }


        Boolean TransportFirstRune = true;
        int TransportTimes = 0;
        public void TransportThreadMethod(object something)
        {
            // int id = (int)something; , when working with Thread[]
            if (TransportFirstRune == true) { TransportReset.WaitOne(); }
            TransportFirstRune = false;
            if (TransportTimes > 20) { TransportTimes = 0; ToReset.Set(); TransportReset.WaitOne(); }
            changePanelColor(panel2);
            TransportTimes++;
            Thread.Sleep(50);
            TransportThreadMethod(something);
        }



        Boolean ToFirstRune = true;
        int ToTimes = 0;
        public void ToThreadMethod(object something)
        {
            // int id = (int)something; , when working with Thread[]
            if (ToFirstRune == true) { ToReset.WaitOne(); }
            ToFirstRune = false;
            if (ToTimes > 30) { ToTimes = 0; FromReset.Set(); ToReset.WaitOne(); }
            changePanelColor(panel3);
            ToTimes++;
            Thread.Sleep(50);
            ToThreadMethod(something);
        }
    }
}
