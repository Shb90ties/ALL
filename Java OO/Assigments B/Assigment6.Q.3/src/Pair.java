import java.util.Map.Entry;

public class Pair<K,V> implements Entry<K, V>{	//Q.3.1~2
	private K key;
	private V value;
	
	public Pair(K key,V value)
	{	this.key=key;	this.value=value;	}
	
	public K getKey()
	{	return key;		}
	
	public V getValue()
	{	return value;	}
	
	public V setValue(V value)
	{	V temp=this.value;
		this.value=value;	return temp;
	}
	
}
