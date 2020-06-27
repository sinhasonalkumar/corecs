package corecs.util;

import java.util.Stack;

public class CorecsUtil {

	public static String stackToString(Stack<Character> stack) {
		StringBuffer result = new StringBuffer();
		
		Object[] array = stack.toArray();
		
		for(Object curChar : array) {
			result.append(curChar);
		}
		
		return result.toString();
	}
	
	
	public static int[] stackToIntegerArray(Stack<Integer> stack) {
		
		int[] intArray = new int[stack.size()];
		
		Object[] array = stack.toArray();
		
		for(int i = 0; i < array.length ; i++) {
			
			intArray[i] = (int) array[i];
		}
		
		return intArray;
	}
	
	public static void main(String[] args) {
		
		//testStackToString();
		testStackToIntegerArray();
	}


	private static void testStackToString() {
		Stack<Character> stack = new Stack<Character>();
		
		stack.push('a');
		stack.push('b');
		stack.push('c');
		
		String result = stackToString(stack);
		
		System.out.println(stack.size());
		
		System.out.println(result);
	}
	
	private static void testStackToIntegerArray() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		int[] result = stackToIntegerArray(stack);
		
		System.out.println(stack.size());
		
		for (int i : result) {
			System.out.print(i);
		}
	}
}
