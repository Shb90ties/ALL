
public class Array {
	private int[] a;	private int counter=0;
	
	public Array(int size)
	{	this.a=new int[size];	}
	
	public void add(int...x)
	{	try{
		for(int i=0;i<x.length;i++)
			a[counter++]=x[i];
		}catch(ArrayIndexOutOfBoundsException ex)
			{	System.out.println("No room!!");
				counter--;	}
		finally{System.out.println("done?");}
	}
	
	public String toString()
	{	String temp=new String();
		for(int i=0;i<counter;i++)
			temp+=a[i]+",";
		return temp;
	}

}
