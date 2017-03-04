import java.util.Iterator;

public class ListIterator<E> implements Iterator<E> {
	private ListItem<E> nextItem;
	
	public ListIterator(ListItem<E> item)
	{	nextItem=item;	}
	
	public E next()
	{	E tmp=nextItem.getElm();
		nextItem=nextItem.getNext();
		return tmp;
	}
	
	public boolean hasNext()
	{	return nextItem!=null;	}
	
	public void remove()
	{	throw new IllegalStateException();	}
	
	public ListItem<E> getNext()
	{	return nextItem;	}
}
