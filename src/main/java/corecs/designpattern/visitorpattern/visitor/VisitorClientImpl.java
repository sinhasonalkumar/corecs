package corecs.designpattern.visitorpattern.visitor;

import java.util.List;

import corecs.designpattern.visitorpattern.path.HighWayPath;
import corecs.designpattern.visitorpattern.path.JunglePath;
import corecs.designpattern.visitorpattern.path.Path;
import corecs.designpattern.visitorpattern.path.StreetPath;

public class VisitorClientImpl implements VisitorClient {

	private List<Path> paths;

	public VisitorClientImpl() {
		this.paths = List.of(new HighWayPath(), new StreetPath(), new JunglePath());
	}

	@Override
	public String calculatePathSummary(Visitor visitor) {

		StringBuilder pathSummary = new StringBuilder();

		pathSummary.append(" Start -> ");
		
		for (Path curPath : paths) {
			pathSummary.append(curPath.accept(visitor) + " -> ");
		}
		
		pathSummary.append(" End");
		
		return pathSummary.toString();
	}

}
