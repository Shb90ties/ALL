
public class Cube extends ThreeDimensional {
	private double A;
	
	public Cube(Point location,double a) {
		super(location);
		A=a;
	}

	@Override
	public double getSurface() {
		return 6*Math.pow(A, 2);
	}

	@Override
	public double getVolume() {
		return Math.pow(A, 3);
	}
	
	@Override
	public String whoAmI()
	{	return ",A cube";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Cube){
			Cube temp=(Cube)x;
			if(location.equals(temp.location) && A==temp.A)
			{	return (getSurface()==temp.getSurface() && getVolume()==temp.getVolume());	}}
		return false;
	}

}
