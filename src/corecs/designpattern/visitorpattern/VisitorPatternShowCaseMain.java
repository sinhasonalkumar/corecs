package corecs.designpattern.visitorpattern;

import corecs.designpattern.visitorpattern.visitor.CarVisitor;
import corecs.designpattern.visitorpattern.visitor.RVVisitor;
import corecs.designpattern.visitorpattern.visitor.VisitorClient;
import corecs.designpattern.visitorpattern.visitor.VisitorClientImpl;

public class VisitorPatternShowCaseMain {

	public static void main(String[] args) {
		
		VisitorClient visitorClient = new VisitorClientImpl();
		
		String pathSummary = visitorClient.calculatePathSummary(new CarVisitor());
		System.out.println(pathSummary);
		
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------\n");
		
		pathSummary = visitorClient.calculatePathSummary(new RVVisitor());
		System.out.println(pathSummary);
		
	}
}
