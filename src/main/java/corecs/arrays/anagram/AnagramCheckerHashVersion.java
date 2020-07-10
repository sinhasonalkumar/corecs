package corecs.arrays.anagram;

import java.util.HashMap;
import java.util.Map;

public class AnagramCheckerHashVersion {
	
	
	public static void main(String[] args) {
		
		//String s1 = "eat";
		//String s2 = "tea";
		
		String s1 = "ad";
		String s2 = "bc";
		
		System.out.println(isAnagram(s1, s2));
		
	}
	
	
	public static boolean isAnagram(String s1, String s2) {
		
		return getHash(s1).equals(getHash(s2));
	}
	

	public static Map<Integer, Integer> getHash(String s) {
		
		Map<Integer, Integer> charMap = new HashMap<Integer, Integer>();
		
		for(int i = 'a'; i <= 'z' ; i++) {
			charMap.put(i,0);
		}
		
		Integer curCharCount ; 
		for(int i =0; i < s.length(); i++){
			
			curCharCount = charMap.get(Integer.valueOf(s.charAt(i)));
			
			charMap.put(Integer.valueOf(s.charAt(i)), ++ curCharCount);
		}
		
		return charMap;
	}
	
}

