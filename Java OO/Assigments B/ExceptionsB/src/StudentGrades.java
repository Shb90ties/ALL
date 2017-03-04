
public class StudentGrades {
	private double[] grades;
	private int index;
	public StudentGrades(int size){
		grades=new double[size];
	}
	public void add(double...g) throws IllegalNumberException{
		for (double i:g)
			if (index<grades.length){
					if (i<0 || i>100)
						throw new IllegalNumberException();
					grades[index++]=i;	
				}
				
	}
	public void bonous () throws IllegalNumberException{
		double grade=0; 
		for(int i=0;i<index-1;i++){	
			grade=grades[i]*1.2;
			if (grade>100)
				throw new IllegalNumberException();
			grades[i]=grade;
		}
	}
	public String toString(){
		String s="";
		for(int i=0;i<index;i++)
			s+=" "+grades[i];
		return s;
	}
}
