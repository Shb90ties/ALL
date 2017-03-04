
public class Door {
	protected boolean open;
	
	public Door(boolean state)
	{this.open=state;}
	
	public Door()
	{this(true);}
	
	public void close()
	{this.open=false;}
	
	public void open()
	{this.open=true;}
	
	public boolean isOpen()
	{return open;}
	
	public void show()
	{if(open) System.out.print("The door is open,|_|");
		else
			System.out.print("The door is closed,|=|");}
	
	
}
