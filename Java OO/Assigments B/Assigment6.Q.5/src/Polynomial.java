import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Polynomial<T extends Number> implements Iterable<T> {
	private Map<T,T> pol;	int ElmIdx;
	
	public Polynomial()
	{	pol=new HashMap<T,T>();
		ElmIdx=0;	}
	
	public void addElm(T degree,T coefficient)
	{	if(degree.intValue()<0 || degree.doubleValue()%1!=0)
		throw new RuntimeException("Illegal Degree number");
		if(notThere(degree))
		{	pol.put(degree, coefficient);	ElmIdx++;	}
		else
		{	pol.put(degree, coefficient);	}
	}
	
	private boolean notThere(T degree)
	{	Set<Entry<T,T>> temp=pol.entrySet();
		Iterator<Entry<T,T>> run=temp.iterator();
		while(run.hasNext())
		{	Entry<T,T> tmp=run.next();
			if(tmp.getKey().intValue()==degree.intValue())
				return false;
		}
		return true;
	}
	
	public Number evaluate(Number n)
	{	double result=0;
		Set<Entry<T,T>> temp=pol.entrySet();
		Iterator<Entry<T,T>> run=temp.iterator();
		while(run.hasNext())
		{	Entry<T,T> next=run.next();
			result+=(Math.pow(n.doubleValue(), next.getKey().intValue()))*(next.getValue().doubleValue());
		}
		if(result%1!=0)
			return result;
		return (int)result;
	}
	
	public Iterator<T> iterator()
	{	Set<Entry<T,T>> temp=pol.entrySet();
		Set<T> tmp=new HashSet<T>();
		Iterator<Entry<T,T>> first=temp.iterator();
		while(first.hasNext())
		{	tmp.add(first.next().getKey());		}
		return tmp.iterator();		}
		
}
