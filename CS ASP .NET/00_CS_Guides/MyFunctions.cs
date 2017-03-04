using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data;
using System.Drawing;

namespace MDI_DragDrop_Events_Rectangle_Square
{
    class MyFunctions
    {
        public int getIndexByColor(Boolean Label, Color c) // Lst[6]
        { int i = decideType(0, Label, 3); return decideColor(i, c); }

        public int getIndexByShape(Boolean Label, Boolean Square)  // Lst[4]
        { int i = decideType(0, Label, 2); return decideShape(i, Square, 1); }

        public int getIndexByShapeColor(Boolean Square, Color c) // Lst[6]
        { int i = decideShape(0, Square, 3); return decideColor(i, c); }

        public int getIndexByTypeShapeColor(Boolean Label,Boolean Square,Color c)
        {   // Lst[12]
            int i = decideType(0, Label, 6); i = decideShape(i, Square, 3);
            return decideColor(i, c);
        }
        // [2][2][3] [Label 0 Buton 1] , [Square 0 Rectangle 1] , [Red 0 Green 1 Blue 2]
        private int decideShape(int i, Boolean Square, int k) { if (!Square) { i += k; } return i; }
        private int decideColor(int i, Color c) { if (c == Color.Green) { i++; } if (c == Color.Blue) { i += 2; } return i; }
        private int decideType(int i, Boolean Label, int k) { if (!Label) { i += k; } return i; }

        public void PutRemoveInLineRow(Object sender,List<Control> list,int left,int top,Boolean Remove,Boolean Line)
        {
            UserControl form = (UserControl)sender;
            foreach(Control c in list)
            {
                c.Location = new Point(left, top);
                if (Remove) { form.Controls.Remove(c); }
                else { form.Controls.Add(c); }
                if (Line) { left += c.Size.Width + 2; }
                else { top += c.Size.Height + 2; }
            }
        }

        public String ToStringListArray(List<Control>[] ListArray)
        {
            String myString = "";
            for(int i=0; i<ListArray.Length; i++)
            { myString += ListArray[i].Count.ToString() + ","; }
            return myString;
        }

        public Control BiggestSmallest(List<Control> List,Boolean Biggest,Boolean Smallest,Boolean ByColor)
        {
            List<Control> temp = new List<Control>();
            foreach (Control c in List) { temp.Add(c); }
            temp.Sort(delegate(Control c1, Control c2) { return SortSize(c1, c2, Biggest); });
            if (ByColor) { temp.Sort(delegate(Control c1, Control c2) { return SortColor(c1, c2, Biggest); }); }
            return temp.FirstOrDefault<Control>();
        }

        public Boolean ExistsList<T>(List<T> list,T obj)
        {
            foreach (T i in list)
            { if (i.Equals(obj)) return true; }
            return false;
        }

        public List<T> mergeLists<T>(List<T> l1, List<T> l2)
        {
            foreach (T c in l2) { l1.Add(c); }
            return l1;
        }

        public List<Control> duplicateList(List<Control> list)
        {
            List<Control> temp = new List<Control>();
            foreach(Control c in list)
            {
                Control t = duplicate(c);
                temp.Add(t);
            }
            return temp;
        }

        public Control duplicate(Control c)
        {
            Control temp;
            if (c.GetType() == typeof(Button)) { temp = new Button(); }
            else { temp = new Label(); }
            temp.Size = c.Size;
            temp.BackColor = c.BackColor;
            return temp;
        }

        public List<Control> SortBySize(List<Control> List,Boolean Reverse)
        {
            List.Sort(delegate(Control c1, Control c2) { return SortSize(c1, c2, Reverse); });
            return List;
        }

        public List<Control> SortByColor(List<Control> List, Boolean Reverse)
        {
            List.Sort(delegate(Control c1, Control c2) { return SortColor(c1, c2, Reverse); });
            return List;
        }

        public List<Control> SortByType(List<Control> List, Boolean Reverse)
        {
            List.Sort(delegate(Control c1, Control c2) { return SortType(c1, c2, Reverse); });
            return List;
        }

        public List<Control> ReverseList(List<Control> List)
        {
            Control[] arr = List.ToArray();
            Control[] arrR = new Control[arr.Length];   int j = 0;
            for(int i=(arr.Length-1); i>=0; i--)
            { arrR[j] = arr[i]; j++; }
            return arrR.ToList<Control>();
        }

        public List<Control> SortByTypeAndOther(List<Control> List,Boolean Reverse,Boolean BySize,Boolean ByColor)
        {
            List<Control> buttons = GetOnlyTypes<Button>(List);
            List<Control> labels = GetOnlyTypes<Label>(List);
            if (BySize) 
            {
                buttons.Sort(delegate(Control c1, Control c2) { return SortSize(c1, c2, Reverse); });
                labels.Sort(delegate(Control c1, Control c2) { return SortSize(c1, c2, Reverse); });
            }
            else
            {
                buttons.Sort(delegate(Control c1, Control c2) { return SortColor(c1, c2, Reverse); });
                labels.Sort(delegate(Control c1, Control c2) { return SortColor(c1, c2, Reverse); });
            }
            List<Control> Listt = new List<Control>();
            foreach(Control c in buttons)
            { Listt.Add(c); }
            foreach (Control c in labels)
            { Listt.Add(c); }
            return Listt;
        }

        public List<Control> GetOnlyTypes<T>(List<Control> List)
        {
            List<Control> temp = new List<Control>();
            foreach(Control c in List)
            {
                if (c.GetType() == typeof(T)) { temp.Add(c); }
            }
            return temp;
        }

        static int SortSize(Control A,Control B,Boolean Reverse)
        {
            int result = 0;
            if ((A.Size.Width * A.Size.Height) > (B.Size.Width * B.Size.Height)) result = 1 ;
            if ((A.Size.Width * A.Size.Height) < (B.Size.Width * B.Size.Height)) result = (-1);
            if (Reverse) { result = result * (-1); } return result;
        }

        static int SortType(Control A, Control B, Boolean Reverse)
        {
            int result = 0;
            if ((A.GetType() == typeof(Label)) && (B.GetType() == typeof(Button))) result = 1;
            if ((A.GetType() == typeof(Button)) && (B.GetType() == typeof(Label))) result = (-1);
            if (Reverse) { result = result * (-1); } return result;
        }

        static int SortColor(Control A, Control B, Boolean Reverse)
        {
            int result = 0;
            if ((A.BackColor.R + A.BackColor.G + A.BackColor.B) > (B.BackColor.R + B.BackColor.G + B.BackColor.B)) result = 1;
            if ((A.BackColor.R + A.BackColor.G + A.BackColor.B) < (B.BackColor.R + B.BackColor.G + B.BackColor.B)) result = (-1);
            if (Reverse) { result = result * (-1); } return result;
        }
    }

    public class Arguments_
    {
        private int IDcount;
        public int getID() { IDcount++; return IDcount; }
        public List<Control>[] Lst { get; set; }
        public List<int> IDLst { get; set; }

        public int ClickCount { get; set; }
        public void ClearArgs()
        {
            for (int i = 0; i < Lst.Length; i++) { Lst[i].Clear(); }
            IDLst.Clear(); ClickCount = 0;
        }
        public MyEvent[] Events_;
        public Arguments_(int numOfLists,int numOfEvents)
        {
            IDcount = 0; IDLst = new List<int>();
            Events_ = new MyEvent[numOfEvents];
            for (int i = 0; i < numOfLists; i++)
            { Events_[i] = new MyEvent(); }
            Lst = new List<Control>[numOfLists];
            for (int i = 0; i < numOfLists; i++)
            { Lst[i] = new List<Control>(); }
        }
    }

    public class FormArgs_
    {
        public Boolean LabelForm { get; set; }
        public event EventHandler formEvent_;
        public void TriggerEvent() { formEvent_(this, new EventArgs()); }
        public FormArgs_(Boolean Labelform)
        { LabelForm = Labelform; }
    }

    public class MyEvent
    { 
        public event EventHandler e_;
        public void Trigger() { e_(this, new EventArgs()); }
    }
}
