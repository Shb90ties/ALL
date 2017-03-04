
public class DrawingBoard {
	private Shape[] shapes;
	private int counter;
	
	public DrawingBoard(int n) {
		if(n<2)n=2;
		this.shapes=new Shape[n];
		counter=0;
	}
	
	public void addOne(Shape x)
	{	if(counter>=shapes.length)
		{	Shape[] temp=new Shape[(int)(shapes.length*1.5)];
			for(int i=0;i<shapes.length;i++){temp[i]=shapes[i];}
			shapes=temp;
			shapes[counter]=x;
			counter++;	}
		else
		{	shapes[counter]=x;
			counter++;	}
	}
	
	public void add(Shape[] x)
	{	for(int i=0;i<x.length;i++)
		{	addOne(x[i]);	}
	}
	
	public void showAll()
	{	for(int i=0;i<counter;i++){
		if(shapes[i] instanceof TwoDimensional){
			System.out.println("The shape is two Dimensional ,");
			System.out.println(shapes[i].whoAmI());
			TwoDimensional temp=(TwoDimensional)(shapes[i]);
			System.out.print("The Shape Area is :"+temp.getArea());
			System.out.println(" ,The Shape Scope is :"+temp.getScope());
			System.out.println();
		}
		if(shapes[i] instanceof ThreeDimensional){
			System.out.println("The Shape is Three Dimensional ,");
			System.out.println(shapes[i].whoAmI());
			ThreeDimensional temp=(ThreeDimensional)(shapes[i]);
			System.out.print("The 3D Shape surface measures ,"+temp.getSurface());
			System.out.println(" ,The 3D Shape volume measures ,"+temp.getVolume());
			System.out.println();
		}}
	}
	
	public Shape getMax()
	{	double max; int place=0;
		if(counter<=0){	System.out.println("No Shapes..."); return null; }
		if(shapes[0] instanceof TwoDimensional)
			{ TwoDimensional temp=(TwoDimensional)(shapes[0]);	max=temp.getArea();}
			else
				{ ThreeDimensional temp=(ThreeDimensional)(shapes[0]); max=temp.getSurface();}
		for(int i=0;i<counter;i++){
			if(shapes[i] instanceof TwoDimensional){
				TwoDimensional temp=(TwoDimensional)(shapes[i]);
				if(temp.getArea()>max){	max=temp.getArea(); place=i;} }
			else
			{ ThreeDimensional tempB=(ThreeDimensional)(shapes[i]);
				if(tempB.getSurface()>max){ max=tempB.getSurface(); place=i; } }
		}
		System.out.println("Biggest 3D Shape "+shapes[place].whoAmI()+" Shape number "+(place+1));
		System.out.println("Area/Surface Area of "+max);
		
		return shapes[place];
	}
	
	public ThreeDimensional getBiggest3D()
	{	int i=0;	double max=0;		int place=0;
		for(i=0;i<counter;i++)
		{	if(shapes[i] instanceof ThreeDimensional)
			{	ThreeDimensional temp=(ThreeDimensional)(shapes[i]); max=temp.getVolume(); place=i;	break;	}}
		if(i>=counter) return null;
		for(int j=0;j<counter;j++)
		{	if(shapes[j] instanceof ThreeDimensional)
			{	ThreeDimensional temp=(ThreeDimensional)(shapes[j]);
				if(temp.getVolume()>max){ max=temp.getVolume();	place=j; }
			}
		}
		return (ThreeDimensional)(shapes[place]);
	}
}
