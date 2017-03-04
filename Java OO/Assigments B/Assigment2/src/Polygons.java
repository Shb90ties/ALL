
public abstract class Polygons extends TwoDimensional {
	protected double height,length;
	
	public Polygons(Point location,double height,double length) {
		super(location);	this.height=height;	this.length=length;
	}

	@Override
	public double getArea() {
		return height*length;
	}

	@Override
	public double getScope() {
		return height*2+length*2;
	}
	
	@Override
	public abstract String whoAmI();
	
	@Override
	public abstract boolean equals(Shape x);

}
