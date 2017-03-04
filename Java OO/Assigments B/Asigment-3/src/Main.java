
public class Main {

	public static void main(String[] args)throws Exception
	{	Complex c1=new Complex();	Complex c2=new Complex(2,6);
		Complex c3=new Complex(4,5);	//Q.1.1/1.2
		Complex c4=new Complex(c1);	//Q.1.3
		System.out.println(c3.toString()); 	//Q.1.4
		System.out.println(c4.equals(c1));	//Q.1.5
		Showable s2=(Showable)c2;
		s2.show();		//Q.1.6
		c1=c1.add(c2);	c2=c2.sub(c3);
		c3=c3.div(c2);	c4=c4.mul(c1);
		Complex[] C={c1,c2,c3,c4};
		for(int i=0;i<4;i++)
		{	C[i].show();	}	//Q1.7
		Utility U=new Utility();
		Showable[] s1={c1,c2,c3,c4};
		System.out.println("Q.2.1 :");
		U.showAll(s1);	//Q.2.1
		Point p1=new Point(1,5);	Point p2=new Point(3,4);
		Card d1=new Card(1,'A');	Card d2=d1;
		Object[] O={p1,p2,c1,c2,c3,d1,d2};
		System.out.println("Q.2.2");
		U.showAll(O);	//Q.2.2
		Complex c5=new Complex(-2,1);
		System.out.println(U.search(O, c5));
		Point p3=new Point(1,5);
		System.out.println(U.search(O, p3));	//Q.2.3
		Object[] O2={c1,c2,c3,c4};
		c5=(Complex)U.max(O2);
		c5.show();	//Q2.4
		Set set1=new Set(10,O);	Set set2=new Set(10,O2);
		Set set3=new Set(20);	//Q3.1
		set3.addObject(O[2]); 	set1.addObject(O[2]);	//Q3.2
		System.out.println(set1.toString());	//Q.3.3
		set3=set1.add(set2);	//if two identical objects will take only one
		System.out.println(set3.toString());
		set3=set1.sub(set2);	//set1-set2=set1 without items that are in set2
		System.out.println(set3.toString());
		set3=set1.mul(set2);	//set3=Objects that are in both sets
		System.out.println(set3.toString());	//Q3.4
		for(int i=0;i<100;i++)
		{	if(set1.forward()==false)	break;	}
		Object o2=set1.getCurrent();
		System.out.println(o2.toString());
		for(int i=0;i<100;i++)
		{	if(set1.backward()==false)	break;	}
		o2=set1.getCurrent();
		System.out.println(o2.toString());
		set1.forward();		set1.forward();		set1.forward();
		set1.reset();	//Takes back to the first Object
		o2=set1.getCurrent();		//Q3.5
		System.out.println(o2.toString());
	}

}
