using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Drawing;

using Common;

namespace Client // change Namespace to fit project
{
    class ControlArgsFuncs
    {
        public ControlArgs toControlArgs(Control ctrl)
        {
            ControlArgs temp = new ControlArgs();
            temp.tType = TypeToString(ctrl);
            temp.sWidth = ctrl.Size.Width;
            temp.sHeight = ctrl.Size.Height;
            temp.cRed = ctrl.BackColor.R;
            temp.cGreen = ctrl.BackColor.G;
            temp.cBlue = ctrl.BackColor.B;
            if (ctrl.GetType() == typeof(Button) || ctrl.GetType() == typeof(Label))
            { temp.tText = ctrl.Text; }
            return temp;
        }

        public Control FromControlArgs(ControlArgs ctrlArgs)
        {
            Control temp = CreateControlType(ctrlArgs.tType);
            temp.Size = new Size(ctrlArgs.sWidth, ctrlArgs.sHeight);
            temp.BackColor = Color.FromArgb(ctrlArgs.cRed, ctrlArgs.cGreen, ctrlArgs.cBlue);
            if (ctrlArgs.tText != "null") { temp.Text = ctrlArgs.tText; }
            return temp;
        }

        public String TypeToString(Control tType)
        {
            if (tType.GetType() == typeof(Button)) { return "Button"; }
            if (tType.GetType() == typeof(Label)) { return "Label"; }
            if (tType.GetType() == typeof(Panel)) { return "Panel"; }
            return "Control";
        }

        public Control CreateControlType(String tType)
        {
            if (tType == "Button") { return new Button(); }
            if (tType == "Label") { return new Label(); }
            if (tType == "Panel") { return new Panel(); }
            return new Control();
        }

        public Boolean EqualsControls(Control A, Control B)
        {
            if (A.Size.Height == B.Size.Width)
            {
                if(A.BackColor.R == B.BackColor.R && A.BackColor.G == B.BackColor.G && A.BackColor.B == B.BackColor.B)
                { return true; }
            }
            return false;
        }
        public Boolean EqualsControlArgs(ControlArgs A, ControlArgs B)
        {
            Control Atemp = FromControlArgs(A);
            Control Btemp = FromControlArgs(B);
            return EqualsControls(Atemp, Btemp);
        }

        public Boolean EqualCrossArgCtrl(ControlArgs A, Control B)
        {
            Control Atemp = FromControlArgs(A);
            return EqualsControls(Atemp, B);
        }

        public Boolean ControlInArgsList(List<ControlArgs> Lst,Control control)
        {
            ControlArgs temp = toControlArgs(control);
            foreach(ControlArgs cA in Lst)
            {
                if (EqualsControlArgs(cA, temp)) return true;
            }
            return false;
        }

        public Boolean ArgsInControlsList(List<Control> Lst, ControlArgs ctrArgs)
        {
            Control temp = FromControlArgs(ctrArgs);
            foreach (Control c in Lst)
            {
                if (EqualsControls(c, temp)) return true;
            }
            return false;
        }

        public Boolean ArgsInControlArgsList(List<ControlArgs> Lst, ControlArgs ctrArgs)
        {
            foreach (ControlArgs cA in Lst)
            {
                if (EqualsControlArgs(cA, ctrArgs)) return true;
            }
            return false;
        }

        public Boolean ControlInControlsList(List<Control> Lst, Control control)
        {
            foreach (Control c in Lst)
            {
                if (EqualsControls(c, control)) return true;
            }
            return false;
        }

        public List<Control> ArgsListToControlList(List<ControlArgs> ArgsLst)
        {
            List<Control> temp = new List<Control>();
            foreach(ControlArgs cA in ArgsLst)
            {
                temp.Add(FromControlArgs(cA));
            }
            return temp;
        }

        public List<ControlArgs> ControlListToArgsList(List<Control> Lst)
        {
            List<ControlArgs> temp = new List<ControlArgs>();
            foreach (Control c in Lst)
            {
                temp.Add(toControlArgs(c));
            }
            return temp;
        }
    }
}
