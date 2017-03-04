import java.util.*;
public class Matrix implements Arithmetic,InputOutput,Cloneable {
	protected int[][] data;	protected int rows,columns;
	
	public Matrix(int rows,int columns)
	{	if(rows<=0 || columns <=0)
		{System.out.println("Illegal Matrix sizes...(Must be >=0)");throw new IligalNumberException();}
		data=new int[rows][columns];
		this.rows=rows;	this.columns=columns;
		read();
	}
	
	private Matrix(int[][] m)
	{	rows=m.length;	columns=m[0].length;	data=m;	  }
	
	private Matrix simpleMath(Object o,int n)throws unEvenMatrixSizeException
	{	if(o.getClass().getName()!="Matrix"){System.out.println("Object given isn't a Matrix.."); return null;}
		Matrix m=(Matrix)(o);	int [][] temp=new int[rows][columns];
		if(m.rows!=this.rows || m.columns!=this.columns)
			throw new unEvenMatrixSizeException();
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
			temp[i][j]=data[i][j]+(m.data[i][j]*n);	}	}
		return new Matrix(temp);
	}
		
	
	public Matrix add(Object o)	throws unEvenMatrixSizeException
	{	return simpleMath(o,1);	}
	
	public Matrix sub(Object o)	throws unEvenMatrixSizeException
	{	return simpleMath(o,-1); }
	
	public Matrix div(Object o)throws divOperationNotSupported
	{	throw new divOperationNotSupported();	}
	
	public Matrix mul(Object o)throws unEvenMatrixSizeException
	{	if(o.getClass().getName()!="Matrix"){System.out.println("Object given isn't a Matrix.."); return null;}
		Matrix m=(Matrix)(o);	int [][] temp=new int[rows][columns];
		if(rows!=m.columns || m.rows!=columns)
			throw new unEvenMatrixSizeException();
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				temp[i][j]=data[j][i]*m.data[i][j];	}
		}
		return new Matrix(temp);
	}
	
	private boolean addNew(int row,int col)
	{	Scanner scanner=new Scanner(System.in);
		System.out.println("Row "+(row+1)+" Column "+(col+1)+":");
		boolean done=true;
		try{	data[row][col]=scanner.nextInt();	}
		catch(InputMismatchException Ex)
		{	System.out.println("Try again isn't Integer...");	done=false;	}
		return done;
	}
	
	public void read()
	{	
		System.out.println("Write the Matrix ,Size "+rows+"x"+columns);
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(addNew(i,j)==false){j--;}	}	}
		System.out.println("done..");
	}
	
	public void write()
	{	for(int i=0;i<rows;i++){
		for(int j=0;j<columns;j++){
			System.out.print(data[i][j]+",");}
		System.out.println();}
	}
	
	public boolean equals(Object o)throws UnevenMatrixSizesOrMissMatch
	{	if(o.getClass().getName()!="Matrix")
		throw new UnevenMatrixSizesOrMissMatch();
		Matrix m=(Matrix)(o);
		if(m.rows!=rows || m.columns!=columns)
		throw new UnevenMatrixSizesOrMissMatch();
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(data[i][j]!=m.data[i][j]){return false;}	}
		}
		return true;
	}
	
	public int valueAt(int i,int j)throws IligalNumberException
	{	if(i>=rows || i<0)
		{throw new IligalNumberException();}
		if(j>=columns || j<0)
		{throw new IligalNumberException();}
		return data[i][j];
	}
	
	public Object clone()throws CloneNotSupportedException
	{	return super.clone();	}
	
}
