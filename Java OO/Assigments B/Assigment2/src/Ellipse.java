
public class Ellipse extends TwoDimensional {
	protected double RadiusA,RadiusB;
	
	public Ellipse(Point Center,double RadiusA,double RadiusB) {
		super(Center);
		this.RadiusA=RadiusA;	this.RadiusB=RadiusB;
	}

	@Override
	public double getArea() {
		return Math.PI*RadiusA*RadiusB;
	}

	@Override
	public double getScope() {
		return Math.PI*(RadiusA+RadiusB);
	}
	
	@Override
	public String whoAmI()
	{	return ",An Ellipse";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Ellipse){
			Ellipse temp=(Ellipse)x;
			if(location.equals(temp.location) && RadiusA==temp.RadiusA && RadiusB==temp.RadiusB)
			{	return (getArea()==temp.getArea() && getScope()==temp.getScope());	}}
		return false;
	}

}
