package corecs.designpattern.strategypattern.strategy.context;

import corecs.designpattern.strategypattern.strategy.iface.OperationStrategy;

public class OperationStrategyContext  {

	private OperationStrategy operationStrategy;
	
	public void setOperationStrategy(OperationStrategy operationStrategy) {
		this.operationStrategy = operationStrategy;
	}
	
	public int executeOperationStrategy(int inputA, int inputB) {
		return this.operationStrategy.execute(inputA, inputB);
	}
	
	
}
