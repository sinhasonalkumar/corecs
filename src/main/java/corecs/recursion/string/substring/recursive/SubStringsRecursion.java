package corecs.recursion.string.substring.recursive;

import java.util.ArrayList;
import java.util.List;

public class SubStringsRecursion {

	public static void main(String[] args) {

		String s = "abcd";

		List<String> allSubStrings = findAllSubStrings(s);

		for (String curStr : allSubStrings) {
			System.out.println(curStr);
		}
	}

	private static List<String> findAllSubStrings(String s) {
		
		List<String> result = new ArrayList<String>();
		
		helper(s, 0, result);
		
		return result;
	}
	
	private static void helper(String s, int start, List<String> result) {
		
		if(start == s.length()) {
			return;
		}
		
		StringBuffer subString = new StringBuffer();
		
		for(int i = start; i < s.length(); i++ ) {
			subString.append(s.charAt(i));
			result.add(subString.toString());
		}
		
		helper(s, start+1, result);
	}
}
