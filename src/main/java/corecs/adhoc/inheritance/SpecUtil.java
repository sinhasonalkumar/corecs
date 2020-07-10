package corecs.adhoc.inheritance;

public abstract class SpecUtil {
	
	public abstract void doSomething(String n);
	
	public abstract void doSomething(int n);
	
	public void doSomething() {
		System.out.println("doSomething in Abstract class SpecUtil ");
	}
}
