package corecs.recursion.string.subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllSubSetOfString {
	
	public static void main(String[] args) {
		
		String s = "abc";
		
		List<String> findAllSubStrings = findAllSubStrings(s);
		
		for (String curSubset : findAllSubStrings) {
			
			System.out.println(curSubset);
		}
	}

	
	public static List<String> findAllSubStrings(String s){
		
		List<String> result = new ArrayList<String>();
		
		helper(s, 0, new Stack<Character>(), result);
		
		return result;
	}
	
	public static void helper(String s , int startIndex, Stack<Character> slate, List<String> result) {
		
		
		if(startIndex == s.length()) {
			result.add(charStackToString(slate));
			return;
		}
		
		
		//exculde
		helper(s, startIndex+1, slate, result);
		
		//include
		slate.push(s.charAt(startIndex));
		helper(s, startIndex+1, slate, result);
		slate.pop();
		
	}
	
	public static String charStackToString(Stack<Character> stack) {
		
		StringBuffer s = new StringBuffer();
		
		for (Character curChar : stack) {
			
			s.append(curChar);
		}
		
		return s.toString();
	}
}
