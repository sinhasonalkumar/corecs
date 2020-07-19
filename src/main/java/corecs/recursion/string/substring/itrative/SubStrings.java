package corecs.recursion.string.substring.itrative;

import java.util.ArrayList;
import java.util.List;

public class SubStrings {
	
	public static void main(String[] args) {
		
		String s = "abcd";
		
		List<String> allSubStrings = findAllSubStrings(s);
		
		for (String curStr : allSubStrings) {
			System.out.println(curStr);
		}
	}

	public static List<String> findAllSubStrings(String s){
	
		List<String> allSubStrings = new ArrayList<String>();
		
		StringBuffer curStr = new StringBuffer();
		
		for(int i = 0; i< s.length(); i++) {
			
			for(int j = i; j< s.length(); j++) {
				curStr.append(s.charAt(j));
				allSubStrings.add(curStr.toString());
			}
			
			curStr = new StringBuffer();
		}
		
		
		return allSubStrings;
	}
	
	
}
