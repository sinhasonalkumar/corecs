package corecs.arrays.word.substring.palindrome;


public class LongestPalindromeSubStringFinder {
	
	
	public static void main(String[] args) {
		
		
		//String s = "racecar";
		//String s = "racecars";
		
		//String s = "abba";
		//String s = "abbba";
		
		//String s = "sabbadaba";
		//String s = "sabbadcbaab";
		
		String s = "sabbadcbbababbxy";
		
		
		System.out.println(findLongestPalindromeSubString(s));
		
	}
	
	
	//racecar -> odd length -> rac e car
	//if start and end pointer expand from middle char then they will be able to cover all chars of string as both half will be symmetric
	
	//abab -> even length -> ab a b 
	//if start and end pointer expand from middle char then one char will be left as both half will not be symmetric 
	// To solve this problem there will be two middle meaning start end pointer have start at one char distance 
	// abba -> a bb a
	
	// Longest palindrome substring could be of odd length or even length with given even length or odd length string 
	//So We have to run through both cases and maxLength result out of both cases... best example is racecar and racecars
	public static String findLongestPalindromeSubString(String s) {
		
		int strLength = s.length();
		
		int maxPalindromeSubStringLength = 0;
		int startIndexOfMaxPalindromeSubString = 0;
		int endIndexOfMaxPalindromeSubString = 0;
		
		int curMaxLength = 0;
		
		for(int curCharPos = 0 ; curCharPos < strLength ; curCharPos++) {
			
			//odd length case
			curMaxLength = expandFromMiddle(s, curCharPos, curCharPos);
			
			if(curMaxLength > maxPalindromeSubStringLength) {
				maxPalindromeSubStringLength = curMaxLength;
				startIndexOfMaxPalindromeSubString = curCharPos - (maxPalindromeSubStringLength/2);
				endIndexOfMaxPalindromeSubString = curCharPos + (maxPalindromeSubStringLength/2);
			}
			
			//even length case
			curMaxLength = expandFromMiddle(s, curCharPos-1, curCharPos);
			
			if(curMaxLength > maxPalindromeSubStringLength) {
				maxPalindromeSubStringLength = curMaxLength;
				startIndexOfMaxPalindromeSubString = curCharPos - (maxPalindromeSubStringLength/2);
				endIndexOfMaxPalindromeSubString = (curCharPos + (maxPalindromeSubStringLength/2)) - 1;
			}
		}
		
		
		return s.substring(startIndexOfMaxPalindromeSubString,endIndexOfMaxPalindromeSubString + 1);
	}
	
	
	public static int expandFromMiddle(String s , int startPointer, int endPointer) {
		
		int palindromeStrLength = 0;
		
		if(s != null && s.length() != 0) {
			
			while(startPointer >= 0 && endPointer < s.length() && s.charAt(startPointer) == s.charAt(endPointer)) {
				
				palindromeStrLength = (endPointer - startPointer) + 1;
				
				startPointer --;
				endPointer ++;
			}
		}
		
		return palindromeStrLength;
	}

}
