using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        Label[] FormLabels; Panel[] FormPanels;
        List<Panel> panelsList;
        Random r = new Random();
        public Form1()
        {
            InitializeComponent();

            //______Already made Labels and Panels________//
            FormLabels = new Label[] { label1, label2 };
            FormPanels = new Panel[] { panel1, panel2 };

            Panel[] panels = new Panel[5];
            for (int i = 0; i < panels.Length; i++)
            {
                panels[i] = new Panel();
                panels[i].Size = new Size(r.Next(30, 80), r.Next(30, 80));
                panels[i].BackColor = Color.FromArgb(r.Next(30, 180), r.Next(30, 180), r.Next(30, 180));
                this.Controls.Add(panels[i]);
            }
            displayArray(panels);

            //_______Array to List, custom Sort,Biggest,Smallest____//
            panelsList = panels.ToList<Panel>();
        }

        public void displayArray(Panel[] panels)
        {
            int left = 10;
            int[] widths = new int[5];
            for (int i = 0; i < panels.Length; i++)
            {
                widths[i] = panels[i].Width;
                if (i > 0) { left = left + widths[i - 1]; }
                panels[i].Location = new Point(left, 30);
            }
        }

        private void Form1_Load(object sender, EventArgs e){}

        public void TransformAToB(Panel A,Panel B)
        {
            A.Size = B.Size;
            A.BackColor = B.BackColor;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            panelsList.Sort(CompareBigger);
                                // List to Array //
            displayArray(panelsList.ToArray());
            //_______Getting the Smallest______//
                // After Array sorted Small to Big //
                TransformAToB(FormPanels[1], panelsList.FirstOrDefault<Panel>());
                                                 //___^___//
        }

        private void button2_Click(object sender, EventArgs e)
        {
            panelsList.Sort(CompareSmallest);
            displayArray(panelsList.ToArray());
            //_______Getting the Biggest______//
            // After Array sorted Big to Small //
                TransformAToB(FormPanels[0], panelsList.FirstOrDefault<Panel>());
                                                //___^___//
        }
        static int CompareBigger(Panel A, Panel B)
        {
            if (A.Width + A.Height > B.Width + B.Height) return 1;
            if (A.Width + A.Height < B.Width + B.Height) return -1;
            return 0;
        }

        static int CompareSmallest(Panel A, Panel B)
        {       // Flip order of returning -1 and 1 from ^
            if (A.Width + A.Height > B.Width + B.Height) return -1;
            if (A.Width + A.Height < B.Width + B.Height) return 1;
            return 0;
        }
    }
}
