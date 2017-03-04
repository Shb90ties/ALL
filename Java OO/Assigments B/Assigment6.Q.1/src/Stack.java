
public  class Stack<T> {
	private T[]  data;
	private  int  top;
	
	public Stack(int size)  {
		data =(T[])new Object[size];
    	top = -1;	}
	
	public void push(T value)  {
		top++;
		if(top>=data.length)throw new RuntimeException("Full..");
		data[top] = value;	}
	
	public T pop()  
	{	if(top<0)throw new RuntimeException("Empty Stack...");
		return data[top--];		}
	
	public T top() 
    {	return data[top];	}
	
}
