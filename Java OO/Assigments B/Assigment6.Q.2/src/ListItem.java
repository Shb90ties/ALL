
public class ListItem<E> {
	private ListItem<E> next;
	private E info;
	
	public ListItem(E info,ListItem<E> next)
	{	this.info=info;		this.next=next;	}
	
	public E getElm()
	{	return info;	}
	
	public ListItem<E> getNext()
	{	return next;	}
	
}
