package corecs.designpattern.compositepattern;

public class CompositePatternDemo {
	
	public static void main(String[] args) {
		
		GenericFileComponent rootDirectory = new Directory("rootDirectory");
		
		GenericFileComponent rootDirectoryFile1 = new File("rootDirectoryFile1");
		GenericFileComponent rootDirectoryFile2 = new File("rootDirectoryFile2");
		GenericFileComponent rootDirectoryFile3 = new File("rootDirectoryFile3");
		
		rootDirectory.add(rootDirectoryFile1);
		rootDirectory.add(rootDirectoryFile2);
		rootDirectory.add(rootDirectoryFile3);
		
		
		
		GenericFileComponent subDirectory1 = new Directory("subDirectory1");
		GenericFileComponent subDirectory1File1 = new File("subDirectory1File1");
		GenericFileComponent subDirectory1File2 = new File("subDirectory1File2");
		
		rootDirectory.add(subDirectory1);
		subDirectory1.add(subDirectory1File1);
		subDirectory1.add(subDirectory1File2);
		
		
		GenericFileComponent subDirectory2 = new Directory("subDirectory2");
		GenericFileComponent subDirectory2File1 = new File("subDirectory2File1");
		GenericFileComponent subDirectory2File2 = new File("subDirectory2File2");
		
		rootDirectory.add(subDirectory2);
		subDirectory2.add(subDirectory2File1);
		subDirectory2.add(subDirectory2File2);
		
		
		rootDirectory.ls();
		
	}

}
