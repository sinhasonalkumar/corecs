package corecs.adhoc.inheritance;

public class SpecImpl extends SpecUtil implements Spec {

	@Override
	public void doSomething() {
		
		System.out.println("doSomething in Concrete class SpecImpl -> doSomething() ");
	}

	@Override
	public void doSomething(int n) {
		
		System.out.println("doSomething in Concrete class SpecImpl ->  doSomething(int n) ");
	}

	@Override
	public void doSomething(String n) {
		
		System.out.println("doSomething in Concrete class SpecImpl  -> doSomething(String n) ");
	}
	
	

	
}
