
public class Program {

	public static void main(String[] args){
		StudentGrades grades=new StudentGrades(4);
		try{
		grades.add(80,90,70,105);
		}
		catch(IllegalNumberException e){
			System.out.println(" Illegal value");
		}
		System.out.println(grades);
		try{
		grades.bonous();
		}
		catch(IllegalNumberException e){
			System.out.println(" Grade is bigger then 100");
		}
		System.out.println(grades);
	}

}
