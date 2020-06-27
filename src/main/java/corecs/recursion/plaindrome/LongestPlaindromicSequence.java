package corecs.recursion.plaindrome;

import java.util.Stack;

import corecs.util.CorecsUtil;

public class LongestPlaindromicSequence {
	
	private static int longestPalindromeSize = Integer.MIN_VALUE;
	private static String longestPalindromeSubString = "";
	
	public static String findLongestPalindromicSequence(String s) {
		 
		char[] arr = s.toCharArray();
		
		helper(arr,0);
		
		return longestPalindromeSubString;
	}
	
	private static void helper(char[] arr, int i) {
		
		if(i == arr.length) {
			return;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int choice = i; choice < arr.length -1; choice++) {
			
			stack.push(arr[choice]);
			
			if(PalindromeFinder.isPalindrome(CorecsUtil.stackToString(stack))) {
				
				if(stack.size() > longestPalindromeSize) {
					longestPalindromeSize = stack.size();
					longestPalindromeSubString = CorecsUtil.stackToString(stack);
				}
			}
		}
		
		stack.clear();
		
		helper(arr, i+1);
	}
	
	public static void main(String[] args) {
		//String s = "acdabadde";
		String s = "xcdcar";
		
		System.out.println("Longest Palindromic SubString -> "+ findLongestPalindromicSequence(s));
	}

}
