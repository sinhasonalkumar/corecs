package corecs.designpattern.strategypattern.strategy.impl;

import corecs.designpattern.strategypattern.strategy.iface.OperationStrategy;

public class AddStrategyImpl implements OperationStrategy {

	@Override
	public int execute(int inputA, int inputB) {
		
		return inputA + inputB;
	}

}
