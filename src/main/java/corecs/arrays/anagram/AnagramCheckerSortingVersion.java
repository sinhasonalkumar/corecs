package corecs.arrays.anagram;

import java.util.Arrays;

public class AnagramCheckerSortingVersion {
	
	
	public static void main(String[] args) {
		
		String s1 = "eat";
		String s2 = "tea";
		
		//String s1 = "ad";
		//String s2 = "bc";
		
		System.out.println(isAnagram(s1, s2));
		
	}
	
	
	public static boolean isAnagram(String s1, String s2) {
		
		return sort(s1).equals(sort(s2));
	}
	
	
	public static String sort(String s) {
		
		char[] chars = s.toCharArray();
		
		Arrays.sort(chars);
		
		return String.valueOf(chars); 
		
	}

	
	
}

