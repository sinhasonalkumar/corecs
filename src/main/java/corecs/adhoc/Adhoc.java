package corecs.adhoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Adhoc {

	
	public static void main(String[] args) {
		
		
		//stackOperation();
		//stringToCharArray();
		//copyStackToList();
		
	//	String s = "abc";
		
      //  System.out.println(s.substring(1,s.length()));
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(1);
		s.push(3);
		
		System.out.println(s.indexOf(s.peek()));
		
		System.out.println(s.size() -1);
		
	}


	private static void stackOperation() {
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(2);
		s.push(3); 
		
		List<Integer> array = new ArrayList<Integer>(s);
		s.push(3);

		for (Integer i : array) {
			System.out.print(i);
		}
		
		
		
		System.out.println("\n------------");
		
		
		
		while(!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
	
	
	public static void stringToCharArray() {
		
		String s = "abc";
		
		char[] arr = s.toCharArray();
		
		String output = String.valueOf(arr);
		
		System.out.println(output);
		
		
	}
	
	public static void copyStackToList() {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		List<String> list = new ArrayList<String>(stack);
		
		System.out.println("stackToList :: ");
		list.forEach(System.out :: print);
		
		System.out.println("\n");
		
		String[] arr = new String[stack.size()];
		stack.toArray();
		
		System.out.print("Stack To Array :: ");
		
		for (String s : arr) {
			System.out.print(s);
		}
		
		
		System.out.println("\n----------------");
		
		System.out.println("Stack Peek " + stack.peek());
		
		System.out.println("----------------");
		
		System.out.print("stack :: ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
	
}



