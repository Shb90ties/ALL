
public class ListNode implements Cloneable {
	
	Object data;
	ListNode nextNode;
	
	
	public ListNode(Object o){
		this(o,null);
	}
	public ListNode(Object o,ListNode node){
		data=o;
		nextNode=node;
	}
	public Object getObject(){
		return data;
	}
	public ListNode getNext(){
		return nextNode;	}
	
	public void show(){
		System.out.print(data.toString()+",");
		if(nextNode!=null)nextNode.show();
	}
	
	public void showRev(){
		if(nextNode!=null)nextNode.showRev();
		System.out.print(data.toString()+",");
	}
	
	public void addAtRec(int k,Object obj)throws ListIndexOutOfBound
	{	if(k==2){	nextNode=new ListNode(obj,nextNode);	return;		}
		if(nextNode==null)	throw new ListIndexOutOfBound();
		if(nextNode!=null && k>2) nextNode.addAtRec(k-1,obj);
	}
	
	public ListNode clone()throws CloneNotSupportedException
	{	ListNode temp=(ListNode)super.clone();
		if(temp.nextNode!=null){	temp.nextNode=(ListNode)super.clone();	}
		return temp;
	}
}
