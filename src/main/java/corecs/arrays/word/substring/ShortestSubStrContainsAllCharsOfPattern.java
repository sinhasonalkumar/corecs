package corecs.arrays.word.substring;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubStrContainsAllCharsOfPattern {

	static Integer missingCharOfPatternCount;

	static Map<Character, Integer> charCountInGivenPattern;
	static Map<Character, Integer> charsFoundForPatterSoFar;
	
	
	public static void main(String[] args) {
	
		//String s = "fixx";
		//String pattern = "ix";
		
		//String s = "fix it";
		//String pattern = "xt";
		
		//String s = "geeksforgeeks";
		//String pattern = "ork";
		
		String s = "this is a test string";
		String pattern = "tist";
		
		String shortestSubStr = find(s, pattern);
		
		System.out.println(shortestSubStr);
		
	}

	public static String find(String s, String pattern) {

		String resultSubStr = null;

		int leftPointer = 0;

		int rightPointer = 0;

		initCharsFoundInPatterSoFar(pattern);
		
		int curWindowLength;

		while (rightPointer < s.length()) {

			if (isMissing()) {
				checkAndAddCharsOfPatternFound(s.charAt(rightPointer));
				rightPointer++;
			}else {
				while(!isMissing()) {
					
					// because of rightPointer++; above as checkAndAddCharsOfPatternFound(s.charAt(rightPointer)) is before rightPointer++; 
					// So isMissing is true before rightPointer++; 
					// in substring we arr not doing s.substring(leftPointer, rightPointer+1);
					
					curWindowLength = (rightPointer - leftPointer);
					
					if(resultSubStr == null || curWindowLength < resultSubStr.length()) {
						
						resultSubStr = s.substring(leftPointer, rightPointer);
					}
					
					checkAndRemoveCharsOfPatternFound(s.charAt(leftPointer));
					leftPointer++;
				}
			}
		}
		
		while(leftPointer < rightPointer &&  !isMissing()) {
			
			curWindowLength = (rightPointer - leftPointer);
			
			if(resultSubStr == null || curWindowLength < resultSubStr.length()) {
				
				resultSubStr = s.substring(leftPointer, rightPointer);
			}
			
			checkAndRemoveCharsOfPatternFound(s.charAt(leftPointer));
			leftPointer++;
		}

		return resultSubStr;

	}

	public static boolean isMissing() {

		if (missingCharOfPatternCount == 0) {
			return false;
		} else {
			return true;
		}

	}

	public static void initCharsFoundInPatterSoFar(String pattern) {

		charCountInGivenPattern = new HashMap<Character, Integer>();
		charsFoundForPatterSoFar = new HashMap<Character, Integer>();
		
		for (int i = 0; i < pattern.length(); i++) {
			if(charCountInGivenPattern.get(pattern.charAt(i)) != null) {
				charCountInGivenPattern.put(pattern.charAt(i), charCountInGivenPattern.get(pattern.charAt(i)) +1);
			}else {
				charCountInGivenPattern.put(pattern.charAt(i), 1);
			}
			
			charsFoundForPatterSoFar.put(pattern.charAt(i), 0);
		}
		
		
		
		missingCharOfPatternCount = pattern.length();
	}

	public static void checkAndAddCharsOfPatternFound(char curChar) {
		
		if (charsFoundForPatterSoFar.get(curChar) != null) {

			if (charsFoundForPatterSoFar.get(curChar) < charCountInGivenPattern.get(curChar)) {
				charsFoundForPatterSoFar.put(curChar, charsFoundForPatterSoFar.get(curChar) + 1);
				missingCharOfPatternCount--;
			} else {
				charsFoundForPatterSoFar.put(curChar, charsFoundForPatterSoFar.get(curChar) + 1);
			}
		}
	}

	public static void checkAndRemoveCharsOfPatternFound(char curChar) {

		if (charsFoundForPatterSoFar.get(curChar) != null) {

			if (charsFoundForPatterSoFar.get(curChar) > charCountInGivenPattern.get(curChar)) {
				charsFoundForPatterSoFar.put(curChar, charsFoundForPatterSoFar.get(curChar) - 1);
			} else {
				charsFoundForPatterSoFar.put(curChar, charsFoundForPatterSoFar.get(curChar) -1 );
				missingCharOfPatternCount++;
			}
		}
	}
}
