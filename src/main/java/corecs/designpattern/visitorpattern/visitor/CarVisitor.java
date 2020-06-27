package corecs.designpattern.visitorpattern.visitor;

import corecs.designpattern.visitorpattern.path.HighWayPath;
import corecs.designpattern.visitorpattern.path.JunglePath;
import corecs.designpattern.visitorpattern.path.StreetPath;

public class CarVisitor implements Visitor {

	@Override
	public String visit(HighWayPath highWayPath) {
		String msg = "CarVisitor visiting highWayPath ";
		System.out.println(msg);
		return msg;
	}

	@Override
	public String visit(StreetPath streetPath) {
		String msg = "CarVisitor visiting StreetPath ";
		System.out.println(msg);
		return msg;
	}

	@Override
	public String visit(JunglePath junglePath) {
		String msg = "CarVisitor visiting JunglePath ";
		System.out.println(msg);
		return msg;
	}

}
