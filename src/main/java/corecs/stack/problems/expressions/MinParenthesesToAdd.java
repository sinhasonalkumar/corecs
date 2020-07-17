package corecs.stack.problems.expressions;

import java.util.Stack;

/*
 Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4
 

Note:

S.length <= 1000
S only consists of '(' and ')' characters.
 
*/

public class MinParenthesesToAdd {
	
public static void main(String[] args) {
		
		//String s = "lee(t(c)o)de)";
		
		//String s = "a)b(c)d";
		
		//String s = "))((";
		
		//String s = "(a(b(c)d)";
		
		//String s = "())";
		
		//String s = "(((";
	
		//String s = "()";
	
		String s = "()))((";
		
		String validStringExpr = buildValidStringExpr(s);
		
		System.out.println("Valid String Expr -> " + validStringExpr);
	}

	private static String buildValidStringExpr(String s) {
		
		StringBuilder validStr = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		
		int addCount = 0;
		
		char curChar;
		
		for(int i=0 ; i< s.length(); i++) {
			
			curChar = s.charAt(i);
			
			if(Character.isLetter(curChar)) {
				validStr.append(curChar);
			}else {
				
				if(curChar == '(') {
					
					stack.push(curChar);
					validStr.append(curChar);
					
				}else {
					
					if(curChar == ')' && !stack.isEmpty() && stack.peek() == '(') {
						
						stack.pop();
						validStr.append(curChar);
					}else {
						validStr.append('(');
						validStr.append(curChar);
						addCount++;
					}
				}
				
			}
		}
		
	  while(!stack.isEmpty()) {
		  
		  validStr.append(')');
		  stack.pop();
		  addCount++;
	  }
		
	  System.out.println("Add Count -> " + addCount);
		
		return validStr.toString();
	}

}
