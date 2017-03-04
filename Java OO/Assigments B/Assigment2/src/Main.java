
public class Main {
	public static void main(String[] args) {
		Point p1=new Point(5,5);	Point p2=new Point(2,2);
		Shape[] s=new Shape[11];
		s[0]=new Ball(p1,8);	s[1]=new Cube(p1,5);
		s[2]=new Circle(p1,6);	s[3]=new Ellipse(p1,8,4);
		s[4]=new Cube(p2,15);	s[5]=new Rectangle(p2,10,15);
		s[6]=new Square(p2,12.5);	s[7]=new Triangle(p1,15,10);
		s[8]=new Triangle(p1,4,3,5);	s[9]=new Triangle(p2,4,3,5);
		s[10]=new Triangle(p2,4,3,5);
		DrawingBoard d=new DrawingBoard(4);
		d.add(s);
		d.showAll();
		System.out.println(s[1].compare(s[4]));
		System.out.println(s[10].compare(s[9]));
		d.getMax();
		for(int i=0;i<s.length;i++)
		{	System.out.println((i+1)+"."+s[i].whoAmI());	}
		s[6]=d.getBiggest3D();
		System.out.println(s[6].whoAmI());
		System.out.println(s[9].equals(s[10]));
		System.out.println(s[8].equals(s[9]));
		
	}

}
