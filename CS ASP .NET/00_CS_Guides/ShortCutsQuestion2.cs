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
	if (reArrangeFirst) { REDr.WaitOne(); }
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