package corecs.designpattern.visitorpattern.visitor;

import corecs.designpattern.visitorpattern.path.HighWayPath;
import corecs.designpattern.visitorpattern.path.JunglePath;
import corecs.designpattern.visitorpattern.path.StreetPath;

public class RVVisitor implements Visitor {

	@Override
	public String visit(HighWayPath highWayPath) {
		String msg = "RVVisitor visiting highWayPath ";
		System.out.println(msg);
		return msg;
	}

	@Override
	public String visit(StreetPath streetPath) {
		String msg = "RVVisitor visiting StreetPath ";
		System.out.println(msg);
		return msg;
	}

	@Override
	public String visit(JunglePath junglePath) {
		String msg = "RVVisitor visiting JunglePath ";
		System.out.println(msg);
		return msg;
	}
}
