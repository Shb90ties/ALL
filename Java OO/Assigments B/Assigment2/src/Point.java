
public class Point {
	
	private double x,y;
	
	public Point(double x,double y)
	{	this.x=x;	this.y=y;	}
	
	public boolean equals(Point p)
	{	return (x==p.x && y==p.y);	}
	
}
