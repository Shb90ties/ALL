
public class List implements Cloneable {
	private ListNode firstNode;
	private ListNode lastNode;
	private String name;


	public List(){
		this("list");
	}
	public List(String listName){
		name=listName;
		firstNode=lastNode=null;
	}
	public void insertAtFront(Object insertItem){
		if(isEmpty())
			firstNode=lastNode=new ListNode(insertItem);
		else
			firstNode=new ListNode(insertItem,firstNode);
	}
	public void insertAtBack(Object insertItem){
		if(isEmpty())
			firstNode=lastNode=new ListNode(insertItem);
		else
			lastNode=lastNode.nextNode=new ListNode(insertItem);
	}
	public Object removeFromFront()throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException(name);
		Object removedItem=firstNode.data;

		if(firstNode==lastNode)
			firstNode=lastNode=null;
		else
			firstNode=firstNode.nextNode;
		return removedItem;
	}
	public Object removeFromBack() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException(name);

		Object removedItem=lastNode.data;
		if(firstNode==lastNode)
			firstNode=lastNode=null;
		else{
			ListNode current=firstNode;

			while(current.nextNode!=lastNode)
				current=current.nextNode;
				
			lastNode=current;
			current.nextNode=null;
		}
		return removedItem;
	}
	public boolean isEmpty(){
		return firstNode==null;
	}
	
	public void print(){
		if(isEmpty()){
			System.out.printf("Empty %s\n", name);
			return;
		}
		System.out.printf("The %s is : ",name);
		ListNode current=firstNode;

		while(current != null){
			System.out.printf("%s",current.data);
			current=current.nextNode;
		}
		System.out.println("\n");
	}
	
	public String toString()
	{	if(isEmpty()){
		System.out.println("Empty List....");}
		String output=new String("");	ListNode cur;
		do{	cur=firstNode;
			output+=cur.getClass().toString()+"/";
			cur=cur.getNext();
		}while(cur != null);
		return output;
	}
	
	public Object removeAt(int k)throws ListIndexOutOfBound,EmptyListException
	{	if(isEmpty())throw new EmptyListException(name);
		ListNode prev=firstNode;	ListNode cur=prev;;
		while(k>1){	k--;
			prev=cur;
			cur=cur.nextNode;
			if(cur==null)throw new ListIndexOutOfBound();	}
		if(cur.nextNode==null || k<=0)throw new ListIndexOutOfBound();
		prev.nextNode=cur.nextNode;
		return cur;
	}
	
	public void show(){
		if(firstNode==null)return;
		else
			firstNode.show();
		System.out.println();
	}
	
	public void showRev(){
		if(firstNode==null)return;
		else
			firstNode.showRev();
		System.out.println();
	}
	
	public void addAt(int k,Object obj)throws ListIndexOutOfBound,EmptyListException
	{	if(k>1 && isEmpty())throw new EmptyListException(name);
		ListNode prev=firstNode;	ListNode cur=prev;
		if(k==1)insertAtFront(obj);
		while(k>1){	k--;
			prev=cur;
			cur=cur.nextNode;
			if(cur==null)
			{ if(k<=1){insertAtBack(obj);}
			  else
				{throw new ListIndexOutOfBound();}}	}
		prev.nextNode=new ListNode(obj,cur);
	}
	
	public void addAtRec(int k,Object obj)throws ListIndexOutOfBound,EmptyListException
	{	if(k>1 && isEmpty())throw new EmptyListException(name);
		if(k<=0)throw new ListIndexOutOfBound();
		if(k==1){insertAtFront(obj);	return;}
		firstNode.addAtRec(k, obj);
		if(lastNode.nextNode!=null)lastNode=new ListNode(obj);
	}
	
	public Object[] toArray()throws EmptyListException
	{	if(isEmpty())throw new EmptyListException(name);
		ListNode curr=firstNode;
		Object[] outPut=new Object[1];	int counter=0;
		while(curr!=null){
			Object[] temp=new Object[counter+1];	counter++;
			for(int i=0;i<outPut.length;i++)
				{temp[i]=outPut[i];}
			temp[temp.length-1]=curr.getObject();
			outPut=temp;
			curr=curr.getNext();
		}
		return outPut;
	}
	
	public List clone()throws CloneNotSupportedException
	{	List temp=(List)super.clone();
		temp.firstNode=firstNode.clone();
		temp.lastNode=lastNode.clone();		//you clone 'this' not temp
		return temp;
	}
}
