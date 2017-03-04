import java.util.*;
import java.util.Map.Entry;


public class Program {
	
	public static <T extends Comparable<T>> Pair<T,T> minMax(Collection<T> c)	//Q.3.3
	{	if(c.isEmpty())
		throw new RuntimeException("The collection is empty....");
		Iterator<T> run=c.iterator();
		T min,max;
		max=min=run.next();
		while(run.hasNext())
		{	T temp=run.next();
			if(min.compareTo(temp)>0)
			{	min=temp;	}
			if(max.compareTo(temp)<0)
			{	max=temp;	}
		}
		return new Pair<T,T>(max,min);
	}
	
	public static <K,V extends Comparable<V>> Pair<Pair<K,V>,Pair<K,V>> minMaxPair(Map<K,V> m)	//Q.3.4
	{	if(m.isEmpty())
		throw new RuntimeException("The collection is empty....");
		Set<Entry<K,V>> entry=m.entrySet();
		V min,max;	Entry<K,V> minE,maxE;
		Iterator<Entry<K,V>> run=entry.iterator();	Entry<K,V> first=run.next();
		min=max=first.getValue();	minE=maxE=first;
		while(run.hasNext())
		{	Entry<K,V> temp=run.next();
			if(min.compareTo(temp.getValue())>0)
			{	min=temp.getValue();	minE=temp;	}
			if(max.compareTo(temp.getValue())<0)
			{	max=temp.getValue();	maxE=temp;	}
		}
		Pair<K,V> pairMax=new Pair<K,V>(maxE.getKey(),maxE.getValue());
		Pair<K,V> pairMin=new Pair<K,V>(minE.getKey(),minE.getValue());
		return new Pair<Pair<K,V>,Pair<K,V>>(pairMax,pairMin);
	}
	
	
	public static void main(String[] args) {
		//Q.3.3
		int[] a={1,5,6,0,-9,4,2,15,4,16,11,2,-8,-7,0,0,0,1};
		ArrayList<Integer> c=new ArrayList<Integer>();
		for(int i:a)
		{	c.add(i);	}
		Pair<Integer,Integer> p=minMax(c);
		System.out.println("Max number "+p.getKey());
		System.out.println("Min number "+p.getValue());
		//Q.3.4
		HashMap<String,Integer> b=new HashMap<String,Integer>();
		b.put("Yoni", 56);	b.put("Moni", 64);	b.put("Toni", 78);	b.put("Aloni", 47);
		Pair<Pair<String,Integer>,Pair<String,Integer>> p2=minMaxPair(b);
		System.out.println("Maxumin name :"+p2.getKey().getKey()+" Score :"+p2.getKey().getValue());
		System.out.println("Minimum name :"+p2.getValue().getKey()+" Score :"+p2.getValue().getValue());
	}

}
