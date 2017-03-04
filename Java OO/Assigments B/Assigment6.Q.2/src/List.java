import java.util.Iterator;

public class List<E extends Comparable<E>> implements Iterable<E>,MinMax<E> {
	private ListItem<E> head;
	private ListItem<Integer> tail;
	
	public List()
	{	head=null;	}
	
	public void addItem(E info)
	{	head=new ListItem<E>(info,head);	}
	
	public E firstElm()
	{	return head.getElm();	}
	
	public Iterator<E>	iterator()
	{	return new ListIterator<E>(head);	}
	
	public E max()
	{	if(head!=null){
			E currentMax=head.getElm();
			Iterator<E> run=iterator();
			while(run.hasNext()){	E tmp=run.next();
				if(currentMax.compareTo(tmp)<0){	currentMax=tmp;		}
			}
			return currentMax;	}
		throw new RuntimeException("The List is empty....");
	}
	
	public E min()
	{	if(head!=null){
			E currentMin=head.getElm();
			Iterator<E> run=iterator();
			while(run.hasNext()){	E tmp=run.next();
				if(currentMin.compareTo(tmp)>0){	currentMin=tmp;		}
			}
			return currentMin;	}
		throw new RuntimeException("The List is empty....");
	}
	
}
