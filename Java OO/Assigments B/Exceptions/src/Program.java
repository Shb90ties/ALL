
public class Program {

	public static void main(String[] args) {
		StudentGrades grades=new StudentGrades(4);
		grades.add(80,90,70,105);
		System.out.println(grades);
		grades.bonous();
		System.out.println(grades);
		Array a=new Array(3);
		a.add(1,2,6,8,7,9);
		System.out.println(a.toString());
	}

}
