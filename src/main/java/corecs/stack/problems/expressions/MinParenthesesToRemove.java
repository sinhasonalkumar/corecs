package corecs.stack.problems.expressions;

import java.util.Stack;

/*
 Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string. 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
 

Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 
*/

public class MinParenthesesToRemove {
	
	public static void main(String[] args) {
		
		String s = "lee(t(c)o)de)";
		
		//String s = "a)b(c)d";
		
		//String s = "))((";
		
		//String s = "(a(b(c)d)";
		
		//String s = "((((((()";
		
		String validStringExpr = buildValidStringExpr(s);
		
		System.out.println("Valid String Expr -> " + validStringExpr);
	}
	
	
	public static String buildValidStringExpr(String s) {
		
		StringBuilder validStr = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		
		int removeCount = 0;
		
		char curChar;
		
		for(int i =0 ; i< s.length(); i++) {
			
			curChar = s.charAt(i);
			
			if(Character.isLetter(curChar)) {
				validStr.append(curChar);
			}else {
				if(curChar == '(') {
					
					stack.push('(');
					validStr.append(curChar);
				
				}else {
					if(curChar == ')' && !stack.isEmpty() && stack.peek() == '(') {
					
						stack.pop();
						validStr.append(curChar);
					}else {
						// ignoring curChar means not adding to valid stringBuilder(curChar not contributing final valid str)
						// So it is emulating remove with respect to final valid stringBuilder
						removeCount++;
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			
			validStr.deleteCharAt(stack.size()-1);
			stack.pop();
			removeCount++;
		}
		
		System.out.println("Total Removed -> " + removeCount);
		
		return validStr.toString();
	}

}
