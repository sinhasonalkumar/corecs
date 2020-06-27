package corecs.designpattern.strategypattern.strategy;

import corecs.designpattern.strategypattern.Operation;

public class StrategyPatterShowCaseMain {

	public static void main(String[] args) {

		int inputA = 10;

		int inputB = 20;
		
		int result = Integer.MIN_VALUE;
		
		
		Calculator calulator = new CalculatorImpl();
		
		result = calulator.calculate(inputA, inputB, Operation.ADD);
		System.out.println(Operation.ADD + " -> " + result);
		
		result = calulator.calculate(inputA, inputB, Operation.SUBTRACT);
		System.out.println(Operation.SUBTRACT + " -> " + result);
		
		result = calulator.calculate(inputA, inputB, Operation.MULTLIPLY);
		System.out.println(Operation.MULTLIPLY + " -> " + result);
		
		result = calulator.calculate(inputA, inputB, Operation.DIVIDE);
		System.out.println(Operation.DIVIDE + " -> " + result);
		
		
		
		
		
	}
}
