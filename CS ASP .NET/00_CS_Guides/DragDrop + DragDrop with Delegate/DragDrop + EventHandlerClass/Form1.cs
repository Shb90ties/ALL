using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DragDrop___EventHandlerClass
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

                // The dragged Button
            button1.MouseDown += new MouseEventHandler(SimpleDragFunction);
                // The Drop Button
            button2.AllowDrop = true;
            button2.DragEnter += new DragEventHandler(DropSETUP);
            button2.DragDrop += new DragEventHandler(DragDropped);

                // Drag with Extra elements
            button3.MouseDown += delegate(object s, MouseEventArgs e) { DragDelegateFunc(s, e, textBox1.Text); };
        }

        private void Form1_Load(object sender, EventArgs e){}

            // _________Drag Functions________________//
        public void SimpleDragFunction(object sender,MouseEventArgs e)
        {
            Button Drag = (Button)sender;
            Drag.DoDragDrop(Drag.Text, DragDropEffects.All);
        }
        public void DragDelegateFunc(object sender,MouseEventArgs e,String myString)
        {
            Button Drag = (Button)sender;
            String DragText = myString + " " + Drag.Text;
            Drag.DoDragDrop(DragText, DragDropEffects.All);
        }

            // ____________Drop Function_______________//
        public void DropSETUP(object sender, DragEventArgs e)
        {       // Syncronize the DragDrop Effect with sending one ^ (example both .ALL)
            e.Effect = DragDropEffects.All;
        }

        public void DragDropped(object sender, DragEventArgs e)
        {
            Button Drop = (Button)sender;
            String DragText = (String)e.Data.GetData(typeof(String));
            Drop.Text = DragText;
        }
    }

}
