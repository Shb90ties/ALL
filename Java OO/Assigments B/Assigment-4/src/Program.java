
public class Program {
	public static void main(String[] args){
		Matrix m1=new Matrix(3,3);
		Matrix m2=new Matrix(2,4);
		try{	m1=m1.add(m2);	}
		catch(unEvenMatrixSizeException Ex)
		{	System.out.println("Uneven Sizes...");
			System.out.println("OutPut M1*2");
			m1=m1.add(m1);	}
		finally{	m1.write();		}
		try{	m1=m1.mul(m2);	}
		catch(unEvenMatrixSizeException Ex)
		{	System.out.println("Uneven size... M1*M1");
			m1=m1.mul(m1);	}
		finally{	m1.write();	}
		System.out.println("New Square Matrix");
		SquareMatrix sM=new SquareMatrix(4);
		try{	System.out.println(m1.equals(sM)); 	}
		catch(UnevenMatrixSizesOrMissMatch Ex)
		{	System.out.println("False...");	 	}
		finally{}
		for(int i=0;i<5;i++){
		try{System.out.println(sM.valueAt((int)(Math.random()*5), 2));}
		catch(IligalNumberException Ex)
		{	System.out.println("Not in the Matrix zone...");	}
		finally{	System.out.println("Done...");	}}
	}

}
