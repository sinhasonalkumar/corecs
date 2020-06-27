package corecs.designpattern.visitorpattern.path;

import corecs.designpattern.visitorpattern.visitor.Visitor;

public interface Path {

	public String accept(Visitor visitor);
}
