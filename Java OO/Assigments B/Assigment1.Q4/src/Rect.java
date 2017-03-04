
public class Rect extends Square {
	private long sideX,sideY;
	
	public Rect(long x,long y)
	{	super(x);
		this.sideX=x; this.sideY=y;	}
	
	public double getArea()
	{return sideX*sideY;}
	
	public double getCirc()
	{return sideX*2+sideY*2;}

}
