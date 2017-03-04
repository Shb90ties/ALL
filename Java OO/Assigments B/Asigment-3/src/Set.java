
public class Set implements Arithmetic,ScanOP {
	private int counter=0;
	private int max;	private int mark=0;
	private Object[] list;
	
	public Set(int max,Set s)
	{	this.max=max;
		this.list=new Object[this.max];
		for(int i=0;i<s.list.length;i++)
		{	addObject(s.list[i]);		}
	}
	
	public Set(Set a,Set b)
	{	this.max=a.max+b.max;
		this.list=new Object[max];
		for(int i=0;i<a.counter;i++)
		{	addObject(a.list[i]);		}
		for(int i=0;i<b.counter;i++)
		{	addObject(b.list[i]);		}
	}
	
	public Set(int max,Object[] a)
	{	this.max=max;
		this.list=new Object[this.max];
		for(int i=0;i<a.length;i++)
		{	addObject(a[i]);		}
	}
	
	public Set(int max)
	{	this.max=max;
		this.list=new Object[this.max];	}
	
	public void addObject(Object o)
	{	if(counter>=max) return;
		for(int i=0;i<counter;i++)
		{	if(o.equals(list[i])) return;	}
		list[counter]=o;
		counter++;
	}
	
	@Override
	public String toString()
	{	if(counter==0)	return "Empty Set...";
		String[] classes=new String[1];
		classes[0]=list[0].getClass().getName();
		for(int i=0;i<counter;i++){
		boolean notThere=true;
			for(int j=0;j<classes.length;j++){
				if(list[i].getClass().getName()==classes[j]){notThere=false;}	}
		if(notThere)
		{	String[] temp=new String[classes.length+1];
			for(int j=0;j<classes.length;j++)
			{	temp[j]=classes[j];			}
			temp[temp.length-1]=list[i].getClass().getName();
			classes=temp;}
		}		//Also possible to copy list to a temp and make null to anything that been taken
		String output=new String("");
		for(int i=0;i<classes.length;i++)
		{	output+=classes[i]+"(";
			int num=0;
			for(int j=0;j<counter;j++)
			{	if(classes[i].equals(list[j].getClass().getName()))
				{	num++;	}	}
			output+=num+"):";
		}
		return output;
	}
	
	public Set div(Object b){
		return null;
	}
	
	public Set add(Object b){
		if(b.getClass().getName()!=this.getClass().getName())
		{	return null;	}
		return (new Set(this,(Set)b));
	}
	
	public Set mul(Object b){
		if(b.getClass().getName()!=this.getClass().getName())
		{return null;}
		Utility u=new Utility();	Set x=(Set)b;
		Object[] temp=new Object[1];	boolean empty=true;
		for(int i=0;i<counter;i++)
		{	if(u.search(x.list, list[i]))
			{	if(empty){temp[0]=list[i];	empty=false;}
				else
				{	Object[] newTemp=new Object[temp.length+1];
					for(int j=0;j<temp.length;j++)
						{newTemp[j]=temp[j];}
					newTemp[newTemp.length-1]=list[i];
					temp=newTemp;	}	}
		}
		if(empty){	return new Set(max);	}
		return new Set(max,temp);
	}
	
	public Set sub(Object b)
	{	if(b.getClass().getName()!=this.getClass().getName())
		{return null;}
		Utility u=new Utility();	Set x=(Set)b;
		Object[] temp=new Object[1];	boolean empty=true;
		for(int i=0;i<counter;i++)
		{	if(u.search(x.list, list[i])==false)
			{	if(empty){temp[0]=list[i];	empty=false;}
			else
			{	Object[] newTemp=new Object[temp.length+1];
				for(int j=0;j<temp.length;j++)
					{newTemp[j]=temp[j];}
				newTemp[newTemp.length-1]=list[i];
				temp=newTemp;	}	}
		}
		if(empty) return this;
		return new Set(max,temp);
	}
	
	
	
	public Object[] getClasses(Class c1)
	{	String Name=c1.getName();
		Object[] temp=new Object[1];	boolean empty=true;
		for(int i=0;i<list.length;i++)
		{	if(Name.equals(list[i].getClass().getName()))
			{	if(empty)
				{temp[0]=list[i];	empty=false;}
				else
				{	Object[] newTemp=new Object[temp.length+1];
					for(int j=0;j<temp.length;j++)
						{newTemp[j]=temp[j];}
					newTemp[newTemp.length-1]=list[i];
					temp=newTemp;	}	}
		}
		if(empty) return null;
		return temp;
	}
	
	public Class[] returnClasses()
	{	if(counter<=0) return null;
		Class[] temp=new Class[counter];
		for(int i=0;i<counter;i++)
		{	temp[i]=list[i].getClass();	}
		return temp;
	}
	
	public void reset()
	{	this.mark=0;	}
	
	public boolean forward()
	{	if(mark>=counter-1) return false;
		else{	mark++;
		return true;}	}
	
	public boolean backward()
	{	if(mark<=0) return false;
		mark--;
		return true;	}
	
	public Object getCurrent()
	{	return list[mark];	}
	
	
}
