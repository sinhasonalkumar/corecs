package corecs.designpattern.strategypattern.strategy;

import corecs.designpattern.strategypattern.Operation;

public interface Calculator {	
	
	public int calculate(int inputA, int inputB, Operation operation);
	
}
