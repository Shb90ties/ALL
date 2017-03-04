
public class Complex implements Showable,Arithmetic,Cloneable {
	private double a,b;
	
	public Complex(double a,double b)
	{	this.a=a;	this.b=b;	}
	
	public Complex(){	this(0,0);	}
	
	public Complex(Complex x)
	{	this.a=x.a;	this.b=x.b;	}
	
	@Override
	public String toString()
	{	return (a+"+"+b+"i");	}
	
	@Override
	public boolean equals(Object c)
	{	Complex c1;
		if(c instanceof Complex) {	c1=(Complex)c;	}
			else
			{	return false;	}
		return (a==c1.a && b==c1.b);
	}
	
	@Override
	public void show()
	{	System.out.println("("+a+"+"+b+"i)"); 	}
	
	@Override
	public Complex add(Object b)
	{	
	}

	@Override
	public Complex sub(Object b)
	{	
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{	return super.clone();	}
}
