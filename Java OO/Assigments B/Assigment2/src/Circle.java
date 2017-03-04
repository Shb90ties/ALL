
public class Circle extends Ellipse {

	public Circle(Point Center, double Radius) {
		super(Center, Radius, Radius);
	}
	
	@Override
	public String whoAmI()
	{	return ",A circle";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Circle){
			Circle temp=(Circle)x;
			if(location.equals(temp.location) && RadiusA==temp.RadiusA)
			{	return (getArea()==temp.getArea() && getScope()==temp.getScope());	}}
		return false;
	}

}
