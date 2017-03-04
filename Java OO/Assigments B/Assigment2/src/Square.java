
public class Square extends Rectangle {
	
	public Square(Point location, double a) {
		super(location, a, a);
	}
	
	@Override
	public String whoAmI()
	{	return ",A Square";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Square){
			Square temp=(Square)x;
			if(location.equals(temp.location) && height==temp.height)
			{	return (getArea()==temp.getArea() && getScope()==temp.getScope());	}}
		return false;
	}

}
