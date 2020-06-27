package corecs.designpattern.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements GenericFileComponent {

	private String name;
	
	private List<GenericFileComponent> components;
	
	public Directory(String directoryName) {
		this.name = directoryName;
		this.components = new ArrayList<GenericFileComponent>();
	}
	
	public void add(GenericFileComponent component) {
		components.add(component);
	}
	
	@Override
	public void ls() {
		
		System.out.println("Directory -> " + name);
		
		for (GenericFileComponent curGenericFileComponent : components) {
			curGenericFileComponent.ls();
		}
		
	}

}
