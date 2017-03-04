
public class Square {
	protected long sides;
	
	public Square(long sides)
	{this.sides=sides;}
	
	public double getCirc()
	{	double circ=sides*4;
		return circ;	}
	
	public double getArea()
	{return Math.pow(sides, 2);}
}
