
public class Complex implements Showable,Arithmetic,Cloneable,Comparable {
	private double a,b;
	
	public Complex(double a,double b)
	{	this.a=a;	this.b=b;	}
	
	public Complex(){	this(0,0);	}
	
	public Complex(Complex x)
	{	this.a=x.a;	this.b=x.b;	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{	return super.clone();	}		//Q.1.9
	
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
	{	if(b instanceof Complex)
		{	Complex a=(Complex)b;
			return (new Complex(this.a+a.a,this.b+a.b));	}
		return null;
	}

	@Override
	public Complex sub(Object b)
	{	if(b instanceof Complex)
		{	Complex a=(Complex)b;
			return (new Complex(this.a-a.a,this.b-a.b));	}
			return null;
	}
	
	@Override
	public Complex mul(Object b)
	{	if(b instanceof Complex)
		{	Complex a=(Complex)b;
			double newA=(this.a*a.a-this.b*a.b);
			double newB=(this.b*a.a+this.a*a.b);
			return (new Complex(newA,newB));	}
			return null;
	}
	
	@Override
	public Complex div(Object b)
	{	if(b instanceof Complex)
		{	Complex a=(Complex)b;
			double newA=(this.a*a.a+this.b*a.b)/(a.a*a.a+a.b*a.b);
			double newB=(this.b*a.a-this.a*a.b)/(a.a*a.a+a.b*a.b);
			return (new Complex(newA,newB));	}
		return null;
	}
	
	public boolean isEqual(Comparable c)
	{	if(c instanceof Complex)
		{	Complex c1=(Complex)c;
			return (c1.a==a && c1.b==b);	}
		return false;
	}
	
	public boolean isLessThen(Comparable c)
	{	if(c instanceof Complex)
		{	Complex c1=(Complex)c;
			return ((this.a+this.b)<=(c1.a+c1.b));	}
		return false;
	}
}