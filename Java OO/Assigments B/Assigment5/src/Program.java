
public class Program {

	public static void main(String[] args)throws ListIndexOutOfBound,EmptyListException
	{	List numbers=new List();
		numbers.insertAtFront(5);
		numbers.insertAtFront(3);
		numbers.insertAtFront(2);
		numbers.insertAtFront(9);
		numbers.addAt(2, 1);
		numbers.addAtRec(3, 57);
		try{	numbers.addAtRec(11, 2);	}
		catch(ListIndexOutOfBound Ex){	System.out.println("Out of Range");	}
		finally{	numbers.show();	}
		numbers.showRev();
	}

}
