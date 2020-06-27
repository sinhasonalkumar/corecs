package corecs.designpattern.visitorpattern.path;

import corecs.designpattern.visitorpattern.visitor.Visitor;

public class JunglePath implements Path {

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
