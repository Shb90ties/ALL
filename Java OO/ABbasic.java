import java.util.Date;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ABbasic
{
	// Types (byte -> short -> int -> long -> float -> double)
	// Types (char -> String)  //  Types (boolean)
	// (inside {}) Local/Instance  // (out of {}) Class/Static/final
	// Operators : (+,-,*,/,%,++,-) , (==,!=,>,<,>=,<=) , (&&,||,!)
				// (>>,<<,>>>>,~,&,^,|) , (=,+=,-=,*=,/=,%=,>>=,&=,^=,|=)
	// Keywords : abstract,assert,break,case,catch,const,continue,default,do
			// else,enum,extends,final,finally,for,goto,if,implements,import
			// instanceof,interface,native,new,package,private,protected,throws
			// try,volatile,while,transient,synchronized
	// Class types : Encapsulation,Inheritance,Polymorphism,Abstraction
	// class X extends Y extends Z
	
	int ClassNum = 50;
	String ClassString = "Class~String";
	final int Z;
	enum Enm{ x,y,z,w }
	
	public ABbasic()
	{
		this.Z = 2;
	}
	
	public ABbasic(int Num,String str)
	{
		this.ClassNum = Num;
		this.ClassString = str;
		this.Z = 60;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Hello java!");
		method();
		int A = plus(5,4);
		System.out.println("method plus 5+4=" + A);
		if(88 > 87){
			System.out.println("88 is bigger than 87");
		}else if(88<89){
			System.out.println("88 is smaller than 87 and 89");
		}else{
			System.out.println("what?...");
		}
		
		int T = 5;
		switch(T){
			case 3:
				System.out.println("T is 3!!!");
				break;
			case 2:
				System.out.println("T is 2!!");
				break;
			default:
				System.out.println("T is "+T);
				break;
		}
		
		System.out.println("While loop : \n");
		int c = 0;
		while(c<=4)
		{
			System.out.println("      value : "+c);
			c++;
		}
		
		System.out.println("do while loop: \n");
		c = 0;
		do
		{
			System.out.println("      value : "+c);
			c++;
		}while(c<=3);
		
		System.out.println("for loop: \n");
		for(int i=0; i<3; i++)
		{
			if(i != 1){ continue; } // skipping to the next
			System.out.println("      value : "+i);
			if(i == 1){ 
				System.out.println("      i == 1 // BREAK!");
				break; }
		}
		
		int[] nums={3,5,8,9,10};
		int[] numbers = new int[5];
		int n = nums.length;	c=0;
		for(int i=(n-1); i>=0; i--)
		{
			numbers[c] = nums[i];
			c++;
		}
		printArray(nums);
		printArray(numbers);
		
		String str = "  SOS!! help!!";
		System.out.println("Print String upper case : "+str.toUpperCase());
		System.out.println("Print String lower case : "+str.toLowerCase());
		System.out.println("Print String Trim unneccassry spaces : "+str.trim());
		System.out.println("String lenght : "+str.length()+"\n");
		
		Date date = new Date();
		System.out.println("Current date: "+date.toString());
		System.out.println("Current date time: "+date.getTime());
		
		SimpleDateFormat myDate = new SimpleDateFormat("'Year='yyyy 'Month='MM 'Day='dd 'Hour='hh 'Minute='mm 'Second='ss 'Clock='a 'Contenent='zzz");
		System.out.println("Date with costume format :\n"+myDate.format(date)+"\n");
		
		ABbasic abc = new ABbasic();
		ABbasic abd = new ABbasic(105,"zzzz");
		System.out.println("ABbasic classes display : ");
		abc.display();
		abd.display();
		System.out.println("ABbasic.ClassNum = "+abc.ClassNum+"\n");
		System.out.println("ABbasic.plus(5,2) = "+abc.plus(5,2)+"\n");
		
		System.out.println("abc.Z changing final : \n");
		//try{
		//	abc.Z = 778;
		//}
		//catch(Exception ex)
		//{
		//	System.out.println("cant");
		//}
		
		//enum Enm{ x,y,z,w }
		System.out.println("enums List: \n");
		Enm enmm;
		System.out.println(Enm.x);
		Enm enmTypes[] = Enm.values();
		for(Enm e: enmTypes)
		{ System.out.println(e); }
	}
	
	static void method(){
		System.out.println("simple function/method");
	}
	
	static int plus(int a,int b){
		return (a+b);
	}
	
	static void printArray(int[] arr){
		System.out.print("\n");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+",");
		}
		System.out.print("\n");
	}
	
	void display(){
		System.out.println(this.ClassNum+" , "+this.ClassString);
	}
}