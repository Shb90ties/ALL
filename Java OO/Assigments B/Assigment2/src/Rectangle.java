
public class Rectangle extends Polygons {
	
	public Rectangle(Point location, double height, double length) {
		super(location, height, length);
	}
	
	@Override
	public String whoAmI()
	{	return ",A Rectangle";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Rectangle){
			Rectangle temp=(Rectangle)x;
			if(location.equals(temp.location) && height==temp.height && length==temp.length)
			{	return (getArea()==temp.getArea() && getScope()==temp.getScope());	}}
		return false;
	}

}
