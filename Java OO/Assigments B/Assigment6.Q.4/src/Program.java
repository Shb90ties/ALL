import java.util.*;
import java.util.Map.Entry;


public class Program {

	public static <T,Ineger> Map<T,Integer> calcFreq(Collection<T> c)	//Q.4.1
	{	if(c.isEmpty())
		throw new RuntimeException("Collection is empty");
		Iterator<T> run=c.iterator();
		Map<T,Integer> output=new HashMap<T,Integer>();
		while(run.hasNext())
		{	int counter=0;	T temp=run.next();
			Iterator<T> runTemp=c.iterator();
			while(runTemp.hasNext())
			{	if(runTemp.next().equals(temp))	counter++;	}
			output.put(temp, counter);
		}
		return output;
	}
	
	public static void main(String[] args) {
		//Q.4.2
		ArrayList<String> s=new ArrayList<String>();
		s.add("Tomy");	s.add("Rony");	s.add("Yonni");	s.add("Car");
		s.add("Car");	s.add("Car");	s.add("Rony");	s.add("Yonni");
		Map<String,Integer> m=calcFreq(s);
		Set<Entry<String,Integer>> m1=m.entrySet();
		for(Entry<String,Integer> i:m1)
		{	System.out.println("Key :"+i.getKey()+" Value :"+i.getValue());	}
		List<Character> l=new LinkedList<Character>();
		l.add('A');	l.add('Z');	l.add('G');	l.add('a');
		l.add('a');	l.add('Z');	l.add('Z');	l.add('Z');
		Map<Character,Integer> ml=calcFreq(l);
		Set<Entry<Character,Integer>> ml1=ml.entrySet();
		System.out.println();
		for(Entry<Character,Integer> i:ml1)
		{	System.out.println("Key :"+i.getKey()+" Value :"+i.getValue());	}
	}

}
