
public class Rational {
	private int num,den;
	private int[] uh;
	
	public Rational(int n,int d)throws RationalZero
	{	num=n;
		if(d==0)
			throw new RationalZero("Lame dude");
		den=d;
	}
	
	public Rational(int[] a,int n)throws ArrayIndexOutOfBoundsException
	{	num=1;	den=1;
		try{
			System.out.println(a[n]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Dude This is shyt i tell ya");
		}
		finally{System.out.println("Jajaj...");}
	}
}
