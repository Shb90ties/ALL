
public class LookableDoor extends Door {
		protected boolean lock;
	
	public LookableDoor()
	{super(true); this.lock=false;}
	
	public LookableDoor(boolean state)
	{super(state); this.lock=false;}
	
	public void open()
	{if(lock) System.out.println("Cant the door is locked!");
		else
			super.open();}
	
	public void close()
	{super.close();}
	
	public void lock()
	{if(super.open) System.out.println("Cant the door is open...");
		else
		{super.close(); this.lock=true;}}
	
	public void unlock()
	{this.lock=false;}
	
	public void show()
	{super.show();
	if(lock) System.out.println(" ,and locked!");
	else
		System.out.println(" ,and unlocked,");}

}
