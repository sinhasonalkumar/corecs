package corecs.stack.problems.expressions;

import java.util.Stack;

/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true 
 */

public class ParenthesesValidator {
	
	public static void main(String[] args) {
	
		//String s = "()";
		//String s = "()[]{}";
		//String s = "(]";
		//String s = "([)]";
		//String s = "{[]}";
		String s = "}{[]}";
		
		boolean isValid = validate(s);
		
		System.out.println(s + " is " + isValid);
	}
	
	public static boolean validate(String s) {
		
		Stack<Character> charStack = new Stack<Character>();
		
		char curChar;
		
		for(int i=0 ; i < s.length() ; i++) {
			
			curChar = s.charAt(i);
			
			if(curChar == '(' || curChar == '{' || curChar == '[') {
				charStack.push(s.charAt(i));
			}else {
				
				if(curChar == ')' && !charStack.isEmpty() && '(' == charStack.peek()) {
					charStack.pop();
				}else {
					
					if(curChar == '}' && !charStack.isEmpty() && '{' == charStack.peek()) {
						charStack.pop();
					}else {
						
						if(curChar == ']' && !charStack.isEmpty() && '[' == charStack.peek()) {
							charStack.pop();
						}else {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

}
