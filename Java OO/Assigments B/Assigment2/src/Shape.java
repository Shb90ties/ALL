
public abstract class Shape {
	protected Point location;
	
	public Shape(Point location){	this.location=location;		}
	
	public abstract String whoAmI();
	
	public abstract int compare(Shape x);
	
	public abstract boolean equals(Shape x);
	
}
