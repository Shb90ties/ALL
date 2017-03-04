
public class StudentGrades {
	private double[] grades;
	private int index;
	public StudentGrades(int size){
		grades=new double[size];
	}
	public void add(double...g){
		for (double i:g)
			if (index<grades.length)
				try{
					if (i<0 || i>100)
						throw new IllegalNumberException();
					grades[index++]=i;	
				}
				catch (IllegalNumberException e){
					if (i<0)
						grades[index++]=0;
					else
						grades[index++]=100;
				}
				
	}
	public void bonous (){
		double grade=0; 
		for(int i=0;i<index-1;i++){	
		try{
			grade=grades[i]*1.2;
			if (grade>100)
				throw new IllegalNumberException();
			grades[i]=grade;
		}
		catch (IllegalNumberException e){
			grade=100;
		}
		finally{
			grades[i]=grade;
		}
		}
	}
	public String toString(){
		String s="";
		for(int i=0;i<index;i++)
			s+=" "+grades[i];
		return s;
	}
}
