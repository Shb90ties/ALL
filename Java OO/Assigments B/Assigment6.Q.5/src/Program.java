
public class Program {

	public static void main(String[] args) {
		Polynomial<Integer> p1=new Polynomial<Integer>();
		p1.addElm(2,5);
		p1.addElm(1, 3);
		p1.addElm(0, 1);
		p1.addElm(1, 4);
		Number result=p1.evaluate(3);
		System.out.println(result.toString());
		for (Integer r : p1)
			System.out.println(r.toString());
	}

}
