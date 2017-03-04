
public abstract class TwoDimensional extends Shape {

	public TwoDimensional(Point location) {
		super(location);
	}

	public abstract double getArea();
	public abstract double getScope();
	
	@Override
	public abstract String whoAmI();
	
	@Override
	public int compare(Shape x)
	{	if(x instanceof ThreeDimensional){
			System.out.println("Comparing 3D to 2D ,Area vs SurfaceArea");
			ThreeDimensional temp=(ThreeDimensional)x;
			if(getArea()>temp.getSurface())	return 1;
			if(temp.getSurface()>getArea())	return -1;
			return 0;	}
		TwoDimensional temp=(TwoDimensional)x;
		if(getArea()>temp.getArea())	return 1;
		if(temp.getArea()>getArea())	return -1;
		return 0;
	}
	
	@Override
	public abstract boolean equals(Shape x);
}
