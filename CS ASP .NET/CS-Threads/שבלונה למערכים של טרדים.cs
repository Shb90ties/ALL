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