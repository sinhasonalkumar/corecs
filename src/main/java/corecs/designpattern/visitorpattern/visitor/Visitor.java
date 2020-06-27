package corecs.designpattern.visitorpattern.visitor;

import corecs.designpattern.visitorpattern.path.HighWayPath;
import corecs.designpattern.visitorpattern.path.JunglePath;
import corecs.designpattern.visitorpattern.path.StreetPath;

public interface Visitor {

	public String visit(HighWayPath highWayPath);
	
	public String visit(StreetPath streetPath);
	
	public String visit(JunglePath junglePath);
}
