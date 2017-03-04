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
