
public class Utility {
	
	public static void showAll(Showable[] a)
	{	for(int i=0;i<a.length;i++){
			a[i].show();
			System.out.println();}
	}
	
	public static void showAll(Object[] a)
	{	for(int i=0;i<a.length;i++){
		if(a[i] instanceof Showable){
			Showable temp=(Showable)a[i];
			temp.show();
			System.out.println();}
		else
			System.out.println(a[i].getClass().toString());
		}
	}
	
	public static boolean search(Object[] a,Object o)
	{	for(int i=0;i<a.length;i++){
		if(o instanceof Comparable && a[i] instanceof Comparable)
		{	Comparable temp=(Comparable)o;
			if(temp.isEqual((Comparable)a[i]))return true;}
		else
		{	if(o.equals(a[i]))return true;	}
		}
		return false;
	}
	
	public static Object max(Object[] a)
	{	for(int i=0;i<a.length;i++){
		if(a[i] instanceof Comparable);
		else
		{	return null;	}
		if(a[i].getClass().getName()!=a[0].getClass().getName())
		{	return null;	}	}
		int m=0;
		for(int i=0;i<a.length;i++){
			Comparable temp=(Comparable)a[i];
			if(temp.isLessThen((Comparable)a[m])==false)
			{	m=i;	}	}
		return a[m];
	}
	
}
