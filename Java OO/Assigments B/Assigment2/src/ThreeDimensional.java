
public abstract class ThreeDimensional extends Shape {

	public ThreeDimensional(Point location) {
		super(location);
	}
	
	public abstract double getSurface();
	public abstract double getVolume();
	
	@Override
	public abstract String whoAmI();
	
	@Override
	public int compare(Shape x)
	{	if(x instanceof TwoDimensional){
			System.out.println("Comparing 3D to 2D ,Area vs SurfaceArea");
			TwoDimensional temp=(TwoDimensional)x;
			if(getSurface()>temp.getArea())	return 1;
			if(temp.getArea()>getSurface())	return -1;
			return 0;	}
		ThreeDimensional temp=(ThreeDimensional)x;
		if(getSurface()>temp.getSurface())	return 1;
		if(temp.getSurface()>getSurface())	return -1;
		return 0;
	}
	
	@Override
	public abstract boolean equals(Shape x);

}
