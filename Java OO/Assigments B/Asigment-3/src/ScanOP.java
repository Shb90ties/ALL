
public interface ScanOP {
	void reset();
	boolean forward();
	boolean backward();
	Object getCurrent();
}
