
public class Ball extends ThreeDimensional {
	private double Radius;
	
	public Ball(Point location,double R) {
		super(location);	Radius=R;
	}

	@Override
	public double getSurface() {
		return 4*Math.PI*Math.pow(Radius, 2);
	}

	@Override
	public double getVolume() {
		return (4*Math.PI*Math.pow(Radius, 3))/3;
	}
	
	@Override
	public String whoAmI()
	{	return ", A Ball";	}
	
	@Override
	public boolean equals(Shape x)
	{	if(x instanceof Ball){
			Ball temp=(Ball)x;
			if(location.equals(temp.location) && Radius==temp.Radius)
			{	return (getSurface()==temp.getSurface() && getVolume()==temp.getVolume());	}}
		return false;
	}

}
