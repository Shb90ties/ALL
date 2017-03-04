byte short int long float double char boolean
interface X { public void draw(); }
interface Y extends X { public void draw(); }
class ggg implements Y { public void draw(){ .... } }
class fff extends ggg { public void draw(){ .... } }
enum month{ jan,feb,apr }
@Override
public void draw()
import myPack;
public class Main {
	public static void main(String[] args)throws IOException
	{	// ClassNotFoundException,InputMismatchException
		ggg g = new ggg(); ggg.draw();
		month M = month.jan;
		month M = month.valueOf("jan");
		month alltypes[] = PLtypes.values();
		for(month m: allypes){ System.out.println("month "+m); }
	}
	public int scan() throws InputMismatchException
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		string str = s.nextString();
		try{...}catch(InputMismatchException)finally{...}
	}
	public void save(){
		FileOutputStream FOS = new FileOutputStream("List.dat");
		ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		OOS.writeObject(object);
	}
	public void load() throw IOException
	{
		try{
			FileInputStream FIS = new FileInputStream("List.dat");
			ObjectInputStream OIS = new ObjectInputStream(FIS);
			object = (objectType)OIS.readObject();
		}catch (IOException e){...}finally{...}
	}
}

