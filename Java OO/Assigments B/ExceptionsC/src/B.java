
public class B extends A {
	@Override
	public void f ()throws SecondException
	{  System.out.println();
		throw new SecondException(); 	}
	@Override
	 public  int  g() {
		  return 4;
	}
	
	public static void main(String[] args) {
		A a=new B();
		System.out.println(a.g());
	}
}
