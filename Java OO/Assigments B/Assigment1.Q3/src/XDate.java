import java.util.Date;


public class XDate extends Date {

	public XDate(int date,int month,int year) 
	{super(year-1900,month-1,date);}

	public int getMonth()
	{return super.getMonth()+1;}
	
	public int getYear()
	{return super.getYear()+1900;}
	
	public XDate addDays(int days)
	{	int Xdate;
		if(super.getDate()+days>31) Xdate=31;
		else{if(super.getDate()+days<1) Xdate=1;
				else 
					Xdate=super.getDate()+days;}
		XDate d1=new XDate(Xdate,this.getMonth(),this.getYear());
		return d1;	}

	public static XDate now()
	{	Date d1=new Date();
		int year=d1.getYear()+1900; int month=d1.getMonth()+1;
		int date=d1.getDate();
		XDate d2=new XDate(date,month,year);
		return d2;	}
	

}
