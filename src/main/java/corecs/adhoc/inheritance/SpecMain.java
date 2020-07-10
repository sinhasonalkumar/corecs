package corecs.adhoc.inheritance;

public class SpecMain {

	public static void main(String[] args) {
		
		Spec spec = new SpecImpl();
		
		spec.doSomething();
		
		spec.doSomething(2);
		
		// can not call as it not define in spec interface
		//spec.doSomething("abc");
	}
}
