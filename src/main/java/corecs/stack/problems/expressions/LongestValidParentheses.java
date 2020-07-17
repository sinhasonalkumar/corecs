package corecs.stack.problems.expressions;

import java.util.Stack;

/*
 
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
  
 */

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		
		//String s = "(()";
		//String s = ")()())";
		//String s = ")()())((()))";
		String s = "((()";
		
		int longestValidParentheses = findLongestValidParentheses(s);
		
		System.out.println("Longest Valid Parentheses -> " + longestValidParentheses);
	}
	
	public static int findLongestValidParentheses(String s) {
		
		Integer maxLength = 0;
		Integer popSofar = 0;
		
		char curChar;
		
		Stack<Character> charStack = new Stack<Character>();
		
		for(int i = 0 ; i< s.length(); i++) {
			
			curChar = s.charAt(i);
			
			if(curChar == '(') {
				charStack.push('(');
			}else {
				if(curChar == ')' && !charStack.isEmpty() && '(' == charStack.peek()) {
					charStack.pop();
					popSofar++;
				}else {
					maxLength = Math.max(maxLength, 2 * popSofar);
					popSofar = 0;
					charStack.clear();
				}
			}
		}
		
		// if string ends before it would done pop operation meaning before closing opening parenthesis
		maxLength = Math.max(maxLength, 2 * popSofar);
		
		return maxLength;
		
	}

}
