
public class Triangle extends Polygons {
	private double sideA,sideB;
	
	public Triangle(Point vertex, double height, double base) {
		super(vertex, height, base);
		System.out.println("Creating Equilateral,Isosceles triangle");
		sideA=Math.sqrt(Math.pow(base/2, 2)+Math.pow(height, 2));
		sideB=sideA;
	}
	
	public Triangle(Point vertex, double height, double base,double hypotenuse) {
		super(vertex, height, base);
		System.out.println("Creating right angled triangle");
		sideA=height;	sideB=hypotenuse;
	}
	
	public Triangle(Point vertex, double height, double base,double sideA,double sideB) {
		super(vertex, height, base);
		this.sideA=sideA;	this.sideB=sideB;
	}
	
	@Override
	public double getArea()
	{	return (height*length)/2;	}
	
	@Override
	public double getScope()
	{	return (sideA+sideB+length);	}
	
	@Override
	public String whoAmI()
	{	return ",A Triangle";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Triangle){
			Triangle temp=(Triangle)x;
			if(location.equals(temp.location) && height==temp.height && length==temp.length)
			{	if(sideA==temp.sideA && sideB==temp.sideB)
					{return (getArea()==temp.getArea() && getScope()==temp.getScope());}	}	}
		return false;
	}

}
