
public class Set {
	private int counter=0;
	private int max;
	private Object[] list;
	
	public Set(int max,Set s)
	{	this.max=max;
		this.list=new Object[max];
		for(int i=0;i<s.list.length;i++)
		{	add(s.list[i]);		}
	}
	
	public Set(int max)
	{	this.max=max;	}
	
	public void add(Object o)
	{	if(counter>=max) return;
		for(int i=0;i<list.length;i++)
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
			for(int j=0;j<list.length;j++)
			{	if(classes[i]==list[j].getClass().getName())
				{	num++;	}	}
			output+=num+"):";
		}
		return output;
	}
}
