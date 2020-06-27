package corecs.oops;

public class TypeVsClass {
	
	public static void main(String[] args) {
		
		BaseFoo foo = new Foo();
		
		
		String typeName = foo.getClass().getTypeName();
		String name = foo.getClass().getName();
		
		System.out.println(typeName);
		System.out.println(name);
	}

}

class BaseFoo {
	
}

class Abc {
	
}

class Foo extends BaseFoo {
	
	private Abc abc;
	
	
}
