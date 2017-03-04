import java.util.Date;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.io.*;

interface FLY{
	public String getS();
}

class cantFLY implements FLY{
	@Override
	public String getS(){
		return "can't fly";
	}
}

class canFLY implements FLY{
	@Override
	public String getS(){
		return "Flyingg!";
	}
}

interface Animal{
	public FLY f = null;
	public String getSS();
}

class Dog implements Animal {
	FLY f;
	public Dog(){
		super();
		f = new cantFLY();
	}
	@Override
	public String getSS(){ return this.f.getS(); }
}

class Bird implements Animal {
	FLY f;
	public Bird(){
		super();
		f = new canFLY();
	}
	@Override
	public String getSS(){ return this.f.getS(); }
}

public class AGtest
{
	
	public static void main(String[] args){
		Animal[] b = { new Bird(), new Dog() };
		System.out.println("b[0] = "+b[0].getSS());
		System.out.println("b[1] = "+b[1].getSS());
	}
}