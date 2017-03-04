
public class Program {

	public static void main(String[] args) {
		LookableDoor d1=new LookableDoor();
		d1.close();
		d1.lock();
		d1.open();
		d1.unlock();
		d1.open();
		d1.show();
		d1.lock();
		d1.close();
		d1.lock();
		d1.show();
	}

}
