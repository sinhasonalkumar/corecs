package corecs.recursion.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Find All Well Formed Brackets



Given a positive integer n, return ALL strings of length 2*n with well formed round brackets.



Example

Input: 3

Output:

[

    "((()))",

    "(()())",

    "(())()",

    "()(())",

    "()()()"

]



Any array containing these five strings in any order is a correct output.



Notes

Input Parameters: Function has one argument, integer n.



Output: Return array of strings containing all possible well formed round brackets string of length 2*n. Order of strings in the returned array is insignificant, e.g. for n=2 both ["(())", "()()"] and ["()()", "(())"] will be accepted.



Constraints:

1 <= n <= 13
Only use round brackets. '(' and ')'.


Custom Input

Input Format: There should be one line for input, containing an integer n. If n = 3, then input should be:

3



Output Format: Let’s denote the size of res is m, where res is the resultant array of string returned by the solution function.

Then, there will be m lines of output, where ith line contains res[i], denoting string at index i of res.

For input n = 3, output will be:

((()))

(()())

(())()

()(())

()()()
 */


public class AllWellFormedBracketsFinder {
	
	
	
	public static void main(String[] args) {
		String[] all_well_formed_brackets = find_all_well_formed_brackets(3);
		
		for (String str : all_well_formed_brackets) {
			System.out.println(str);
		}
	}
	

    /*
     * Complete the function below.
     */
	private static String[] find_all_well_formed_brackets(int n) {
        List<String> result =  helper(n,new Stack<Character>(),0,0, new ArrayList<String>());
       return (String[]) result.toArray(new String[result.size()]);
    }
    
    private static List<String> helper(int n, Stack<Character> slate, int leftBracketCount, int rightBracketCount, List<String> result) {
        
        if(rightBracketCount > leftBracketCount) {
            return result;
        }
        
        if(slate.size() == 2 * n){
            if(leftBracketCount == rightBracketCount) {
                StringBuilder s = new StringBuilder();
                for(Character c:  slate){
                    s.append(c);
                }
                result.add(s.toString());
                return result;
            }else{
                return result;    
            }
            
        }
        
        slate.push('(');
        helper(n,slate,leftBracketCount + 1, rightBracketCount, result);
        slate.pop();
        
        slate.push(')');
        helper(n,slate,leftBracketCount , rightBracketCount + 1, result);
        slate.pop();
        
        return result;
        
    }



}
