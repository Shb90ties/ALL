Question 1 Events
{
//__________Divid into different lists____________//

public List<Control>[] SplitIntoLists(List<Control> overallList,int ListAmounts)
{
	List<Control>[] temp = new List<Control>[ListAmounts];
	for (int i = 0; i < temp.Length; i++)
	{ temp[i] = new List<Control>(); }
	foreach (Control c in overallList)
	{
	if (ConditionA(c)) { temp[0].Add(c); }
	if (ConditionB(c)) { temp[1].Add(c); }
	if (ConditionC(c)) { temp[2].Add(c); }
	if (ConditionD(c)) { temp[3].Add(c); }
}
return temp;
}

public Boolean ConditionA(Control c)
{
	if (c.GetType() == typeof(Label) && c.BackColor != Color.White) return true;
    return false;
}
public Boolean ConditionB(Control c)
{
}
public Boolean ConditionC(Control c)
{
}
public Boolean ConditionD(Control c)
{
}

//_________Passed on Class with Event_________//

public class Arguments_
{
    private int IDcount;
    public int getID() { IDcount++; return IDcount; }
    public List<Control>[] myLists { get; set; }
	public List<int> IDclicked { get; set; }
	public List<Control>[][] Shapes { get; set; }
	
    public void AddList(List<Control> newList)
    {
        List<Control>[] temp = new List<Control>[myLists.Length + 1];
        for (int i = 0; i < myLists.Length; i++) { temp[i] = myLists[i]; }
        temp[myLists.Length] = newList;
        myLists = temp;
    }
	public void MergeLists(List<Control> newList,int index)
	{
		foreach (Control c in newList) { myLists[index].Add(c); }
	}
	public List<Control> MergeListsA_B(List<Control> ListA,List<Control> ListB)
    {
        foreach (Control c in ListB) { ListA.Add(c); }
        return ListA;
    }
	public void ClearLists()
    {
        for (int i = 0; i < myLists.Length; i++) { myLists[i].Clear(); }
		for (int i = 0; i < 4; i++ )
        {
            for (int j = 0; j < 3; j++ )
            { Shapes[i][j].Clear(); }
        }
        IDclicked.Clear();
    }
    public event EventHandler Event_;
	public void triggerEvent() { Event_(this, new EventArgs()); }

    public Arguments_()
    {
        IDcount = 0; IDclicked = new List<int>();
        myLists = new List<Control>[1];
        myLists[0] = new List<Control>();
    }
    public Arguments_(int numOfLists)
    {
        IDcount = 0; IDclicked = new List<int>();
        myLists = new List<Control>[numOfLists];
        for (int i = 0; i < numOfLists;i++)
        { myLists[i] = new List<Control>(); }  
    }
}

public class FormArgs
{
	public Boolean labels { get; set;}
	public event EventHandler formEvent_;
	public void triggerEvent() { formEvent_(this, new EventArgs()); }
	public Control[] minMax { get; set; }
	// in-form private objects
	public FormArgs()
	{
		labels = true;
		minMax = new Control[2];
	}
	public FormArgs(Boolean Label)
	{ labels = Label; }
}

Arguments_ Args;
FormArgs Fargs;// on sons
	// create on the launcher form //
	Args = new Arguments_();
	Args = new Arguments_(NumberOfLists);
	// on for(i->n) creating small forms //
		FormArgs temp = new FormArgs();
		// if i==0 Fargs.labels = true...
		new Form(Args,temp)
	// pass to all constructers// 
(Arguments_ arg,FormArgs fArg)
this.Args = arg; this.Fargs = fArg;

//_______Get Biggest Smallest from List_________//

Control temp = BiggestSmallest(Listtt,true);
if (temp == null) { return; }

public Control BiggestSmallest (List<Control> list,Boolean Biggest)
{
	if (!list.Any()) { return null; }
    Control temp = list.FirstOrDefault<Control>();
	foreach(Control c in list)
    { temp = bigSmallCondition(temp, c,Biggest); }
    return temp;
}
public Control bigSmallCondition(Control A,Control B,Boolean Biggest)
{
    if(Biggest)
    {
        if ((A.Width * A.Height) > (B.Width * B.Height)) return A;
        return B;
    }
    if ((A.Width * A.Height) < (B.Width * B.Height)) return A;
    return B;
}

//________Set Controls in a row________//

public void ControlsInRow(List<Control> controlsList)
{
	int left = 2;
	foreach(Control c in controlsList)
	{
		c.Location = new Point(left, 2);
		left += (c.Width + 2);
		this.Controls.Add(c);
	}
}

//_______Costume Compare for Sort___________//

static int myCompare(Control A,Control B)
{
    if ((A.Width * A.Height) > (B.Width * B.Height)) return 1;
    if ((A.Width * A.Height) < (B.Width * B.Height)) return -1;
    return 0;
}

static int myCompareLB(Control A,Control B)
{
	if (A.GetType() == typeof(Button) && B.GetType() == typeof(Label)) return 1;
    if (A.GetType() == typeof(Label) && B.GetType() == typeof(Button)) return -1;
            return 0;
}

//_________Return new duplicate(Button or Label)__________//

public Control duplicate(Control c)
{
    Control temp;
    if (c.GetType() == typeof(Button)) { temp = new Button(); }
	else { temp = new Label(); }
    temp.Size = c.Size;
    temp.BackColor = c.BackColor;
    return temp;
}

//_________Exists in List_______________//

public Boolean ExistsList(List<Label> list, Label l)
{
	foreach(Label i in list)
    {
		if (i == l) return true;
	}
	return false;
}

//________Merge two lists__________//

public List<Control> mergeLists(List<Control> l1,List<Control> l2)
{
	list<Control> temp = new list<Control>();
	foreach(Control c in l1){ temp.Add(c); }
	foreach(Control c in l2){ temp.Add(c); }
	return temp;
}

//________Exists inside IDS______//

public Boolean myIDClicked(int myID)
{
	foreach(int id in Args.IDclicked)
	{
		if (myID == id) { return true; }
	}
    return false;
}
	
}
//__________________________________________________________________//
Question 1 DragDrop
{
	
//_________DragDrog stracture__________//

	// in the DRAGGED object
private void X_MouseDown(object sender, MouseEventArgs e)
{
	type Drag = (type)sender;
	Args.ClearLists();
	// Installments
	Args.IDclicked.Add(myID);
	Drag.DoDragDrop(something, DragDropEffects.All);
}
	// in the DROP object
private void x_DragEnter(object sender, DragEventArgs e)
{
	e.Effect = DragDropEffects.All;
}
	// in the DROP object
private void x_DragDrop(object sender, DragEventArgs e)
{
	// installments
	Args.IDclicked.Add(myID);
	// trigger Events
}

//__________Stracture Dynamically_______//

DRAG.MouseDown += new MouseEventHandler(X_MouseDown);

DROP.AllowDrop = true;
DROP.DragEnter += new DragEventHandler(x_DragEnter);
DROP.DragDrop += new DragEventHandler(x_DragDrop);

private void X_MouseDown(object sender, MouseEventArgs e)
{
	Button Drag = (Button)sender;
	Drag.DoDragDrop("Hello", DragDropEffects.All);
}

private void x_DragEnter(object sender, DragEventArgs e)
{ e.Effect = DragDropEffects.All; }
private void x_DragDrop(object sender, DragEventArgs e)
{
	Button Drop = (Button)sender;
	Drop.Text = (String)e.Data.GetData(typeof(String));
}

//__________Events structure_____________//

	//_________in Arguments_ class________// 
	public event EventHandler Event_;	// Question 1
		Event_ += Event in Child
	public event EventHandler Event_B;	// Question 2
		EventB += Event in Child.UserControls
	public void triggerEvent() { Event_(this, new EventArgs()); }
	public void triggerEventB() { Event_B(this, new EventArgs()); }
	//__________in FormArguments class______//
	public event EventHandler formEvent_;
		formEvent_ += Event in Child (add its ID)
		formEvent_(this,...) // lanch in userControl on Mousedown&Drop
	//______Every Event function
		if( myID not in ids) return;

	
}
//__________________________________________________________________//
Question 2 Threads
{
	
using System.Threading.Tasks;
using System.Threading;
using System.Timers;

//_________Function with Invoke_______//

public void FunctionName(object obj)
{
	if (this.InvokeRequired)
    {
		this.Invoke((MethodInvoker)delegate { FunctionName(obj); });
    }
    else
    {
		//something
    }
}

//________Threads and their AutoResets_____//

AutoResetEvent[] reload = new AutoResetEvent[3];
AutoResetEvent[] unload = new AutoResetEvent[3];

Thread[] packr = new Thread[3];
Thread[] unpackr = new Thread[3];

for(int i=0; i<3; i++)
{
	reload[i] = new AutoResetEvent(false);
	unload[i] = new AutoResetEvent(false);
	packr[i] = new Thread(new ParameterizedThreadStart(packingFunc));
	unpackr[i] = new Thread(new ParameterizedThreadStart(UnpackingFunc));
	packr[i].Start(identifier any type)
	unpackr[i].Start(identifier any type)
}

public void packingFunc(object IDobj)
{
	int idx = getThreadID(IDobj);
	if( !UC.lists_[idx].any() ){ unload[idx].Set(); return; }
	if( condition to stop )
	{
		// reset public virables in USERControls
		unload[idx].Set(); reload[idx].WaitOne();
	}
	//Action
	Thread.Sleep(100);
	packingFunc(IDobj);
}

Boolean firstRun = true;
public void UnpackingFunc(object IDobj)
{
	int idx = getThreadID(IDobj);
	if(firstRun){ unload[idx].WaitOne(); }
	firstRun = false;
	if( condition to stop )
	{
		// reset public virables in UserControls
		reload[idx].Set(); unload[idx].WaitOne();
	}
	//Action
	Thread.Sleep(100);
	UnpackingFunc(IDobj);
}

public int getThreadID(object IDobj)
{
	// conditions
}

//_____________in UserControls Threads________//

public List<Control>[] lists_ = new List<Control>[3];
//or just Label //

// constructer //
	for (int i = 0; i < 3; i++ ){ lists_[i] = new List<Label>(); }
	// insert to lists_[0].Add(....) lists_[1]......
		// according to sorting request
	//....
	for (int i = 0; i < 3; i++){ lists_[i].Sort(myCompare); }

//_________Remove from Controls and lists_______//

public void RemoveDis(Label l,int idx)
{
	if (this.InvokeRequired)
    {
		this.Invoke((MethodInvoker)delegate { RemoveDis(l,idx); });
    }
	else
    {
		lists_[idx].Remove(l);
		this.Controls.Remove(l);
    }
}

//____________reArranging function in the background_____//

Boolean reArrangeFirst = true; int reLeft= 2;
public void reArrange()
{
	if (reArrangeFirst) { ArrangeReset.WaitOne(); }
	reArrangeFirst = false;
	for(int i -> original unchanged array )
	{
		if(conditions(i))
		{
			invokedMethod(i,new Point(reLeft,top));
			Thread.sleep(100);
		}
	}
	reLeft = 2;
	reArrange();
}
	
}
//__________________________________________________________________//
Question 3 Client Server
{
	
//________Client class___________//

using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels;

using Common;

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

ControlArgsFuncs CAF = new ControlArgsFuncs();
private ICommon myICommon;

HttpChannel channel = new HttpChannel();
ChannelServices.RegisterChannel(channel, false);
myICommon = (ICommon)Activator.GetObject(typeof(ICommon),"http://localhost:1234/_Server_");

//______Client GET function________//

myRequest result;
try
{ result = myICommon.getUpdated(request); }
catch
{ MessageBox.Show("Can't reach server"); return; }


//__________Server Class____________//

using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels;
using System.Collections;

using Common;

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

HttpChannel chnl = new HttpChannel(1234);
ChannelServices.RegisterChannel(chnl, false);
RemotingConfiguration.RegisterWellKnownServiceType(typeof(ServerPart),"_Server_",WellKnownObjectMode.Singleton);




class ServerPart : MarshalByRefObject, ICommon
{
	ControlArgsFuncs CAF = new ControlArgsFuncs();
	List<ControlArgs>[] Lst = new List<ControlArgs>[3];
	Boolean firstRun = true;
	
	public myRequest getUpdated(myRequest clientCurrent)
	{
		if(firstRun)
		{ for(int i=0; i<3; i++)
			{	// Server virables installation
				Lst[i] = new List<ControlArgs>();
			}}
		firstRun = false;
		// Actions
		return new myRequest(5);
	}
	
	static int myCompare(ControlArgs A,ControlArgs B)
    {
		if (A.getColorSum() > B.getColorSum()) return 1;
		if (A.getColorSum() < B.getColorSum()) return -1;
		return 0;
    }
}
	
}
//__________________________________________________________________//
Common Class
{
	
using System;
using System.Collections.Generic;
using System.Text;
using System.Runtime.Remoting.Messaging;
using System.Drawing;
using System.Collections;

namespace Common
{
    public interface ICommon 
    {
        myRequest getUpdated(myRequest clientCurrent);
    }

    [Serializable]
    public class myRequest
    {
        private ControlArgs[][] controls_ { get; set; }
		private Boolean emptyControls { get; set; }
        public int returnArrN { get; set; }
        public String myText { get; set; }
		
        public myRequest(int numberOfLists)
        {
            controls_ = new ControlArgs[numberOfLists][]; emptyControls = true;
            for(int i=0; i<numberOfLists; i++)
            { controls_[i] = new ControlArgs[1]; }
            returnArrN = 0;
            myText = "null";
        }
		
        public String ToMyString()
        {
            String string_ = "";
            string_ += returnArrN.ToString() + " ,";
            string_ += myText.ToString() + " ,";
            string_ += "Arrays : "+controls_.Length.ToString() + " ,\n";
			if (emptyControls) { return string_; }
            for (int i = 0; i < controls_.Length; i++ )
            {
                for (int j = 0; j < controls_[i].Length; j++ )
                { string_ += controls_[i][j].getColorSum().ToString() + " ,"; }
                string_ += "\n";
            }
            return string_;
        }

        public void setControls_(List<ControlArgs> listI,int index)
        {
			emptyControls = false;
            controls_[index] = new ControlArgs[listI.Count];
            int i = 0;
            foreach(ControlArgs j in listI)
            { controls_[index][i] = j; i++; }
        }

        public List<ControlArgs> getControls_(int index)
        {
            List<ControlArgs> temp = new List<ControlArgs>();
            for(int i=0; i<controls_[index].Length; i++)
            { temp.Add(controls_[index][i]); }
            return temp;
        }
    }

    [Serializable]
    public class ControlArgs
    {
        public int sWidth { get; set; }
        public int sHeight { get; set; }
        public int cRed { get; set; }
        public int cGreen { get; set; }
        public int cBlue { get; set; }
        public String tType { get; set; }
        public String tText { get; set; }
        public int getColorSum()
        { return (cRed + cGreen + cBlue); }
        public ControlArgs(){ tText = "null"; }
    }
}
	
}
//__________________________________________________________________//
ControlArgs Functions
{

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


}
//__________________________________________________________________//
My Functions
{
	
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data;
using System.Drawing;

namespace MDI_DragDrop_Events_Rectangle_Square // Change
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

}



















