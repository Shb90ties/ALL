
public class Program {

	public static void main(String[] args) {
		int[] A={2,1,8,3,5,7,5,6,3,7,11,2,12};
		List<Integer> L=new List<Integer>();
		for(int i:A)
		{	L.addItem(i);	}
		System.out.println("Max number: "+L.max());
		System.out.println("Min number: "+L.min());
	}

}
