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