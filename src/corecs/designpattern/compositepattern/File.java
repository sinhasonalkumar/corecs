package corecs.designpattern.compositepattern;

public class File implements GenericFileComponent {

	private String name;
	
	public File(String fileName) {
		this.name = fileName;
	}
	
	@Override
	public void ls() {
		System.out.println("File -> " + name);
	}

	@Override
	public void add(GenericFileComponent genericFileComponent) {
		throw new RuntimeException("Invalid Operation");
	}

}
