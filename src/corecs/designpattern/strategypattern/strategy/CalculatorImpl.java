package corecs.designpattern.strategypattern.strategy;

import corecs.designpattern.strategypattern.Operation;
import corecs.designpattern.strategypattern.strategy.context.OperationStrategyContext;
import corecs.designpattern.strategypattern.strategy.impl.AddStrategyImpl;
import corecs.designpattern.strategypattern.strategy.impl.DivideStrategyImpl;
import corecs.designpattern.strategypattern.strategy.impl.MultiplyStrategyImpl;
import corecs.designpattern.strategypattern.strategy.impl.SubstractStrategyImpl;

public class CalculatorImpl implements Calculator {

	private OperationStrategyContext operationStrategyContext;
	
	public CalculatorImpl() {
		this.operationStrategyContext = new OperationStrategyContext();
	}

	@Override
	public int calculate(int inputA, int inputB, Operation operation) {

		int result = Integer.MIN_VALUE;

		switch (operation) {

		case ADD:
			operationStrategyContext.setOperationStrategy(new AddStrategyImpl());
			result = operationStrategyContext.executeOperationStrategy(inputA, inputB);
			break;
		case SUBTRACT:
			operationStrategyContext.setOperationStrategy(new SubstractStrategyImpl());
			result = operationStrategyContext.executeOperationStrategy(inputA, inputB);
			break;
		case MULTLIPLY:
			operationStrategyContext.setOperationStrategy(new MultiplyStrategyImpl());
			result = operationStrategyContext.executeOperationStrategy(inputA, inputB);
			break;
		case DIVIDE:
			operationStrategyContext.setOperationStrategy(new DivideStrategyImpl());
			result = operationStrategyContext.executeOperationStrategy(inputA, inputB);
			break;

		default:
			throw new RuntimeException("Invalid Operation Strategy");
		}

		return result;
	}
}
