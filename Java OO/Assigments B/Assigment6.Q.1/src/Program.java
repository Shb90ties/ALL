
public class Program {

	public static void main(String[] args)
	{	Stack<Double> s=new Stack<Double>(5);		//Q.1.1/1.2
		Stack<String> s1=new Stack<String>(2);
		s1.push("Strings");	s1.push("Stringz");
		s.push(5.5);	s.push(3.3);
		double x=s.pop();
		System.out.println(x);
		s.push(x);	s.pop();
		System.out.println(s.top());
		try{s.push(3.1);	s.push(3.2);	s.push(3.3);
		s.push(3.4);	s1.push("Last");}
		catch(RuntimeException Ex)
		{	System.out.println("Full list");	}
		finally{}
		
		Stack<Stack<Integer>> stS=new Stack<Stack<Integer>>(2);		//Q.1.3
		Stack<Integer> s2=new Stack<Integer>(5);
		Stack<Integer> s3=new Stack<Integer>(5);
		int[] temp={1,2,3,4,5};	int[] temp2={5,4,3,2,1};
		stS.push(s2);
		for(int i:temp)
		{	stS.top().push(i);	}
		System.out.println(stS.top().top());
		stS.push(s3);
		for(int i:temp2)
		{	stS.top().push(i);	}
		System.out.println(stS.top().top());
	}

}
