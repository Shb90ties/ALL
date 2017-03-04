using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WinForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            Shape s1 = new Square(5,55,"Bob");
            Shape s2 = new Turtle(0, 0, "tutle");

            label1.Text = s1.print() + " " + s1.getSpace() + "\n" +
                            s2.print() + " " + s2.getSpace();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }
    }

    public abstract class Shape
    {
        public int width, length;
        public String name;

        public Shape(int w,int l)
        {
            this.width = w;
            this.length = l;
        }

        public abstract int getSpace();

        public virtual String print()
        {
            // doens't have to be implemented
            return "Basic shape";
        }
    }

    public class Square : Shape
    {
        public Square(int w, int l,String name) : base(w,l)
        {
            base.name = name;
        }

        public override int getSpace()
        {
            return (base.width + base.length);
        }
    }

    public class Turtle : Shape
    {
        public Turtle(int w, int l, String name)
            : base(w, l)
        {
            base.name = name;
        }

        public override int getSpace()
        {
            return (base.width + base.length);
        }

        public override string print()
        {
            return "this is a " + base.name;
        }
    }
}
