package corecs.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllValidPalindromeFinder {

	public static void main(String[] args) {
		
		char[] arr = {'a','a','b'};
		//char[] arr = {'a','b','a'};
		
		List<String> allPalindrome = findAllPalindrome(arr);
		
		allPalindrome.stream().forEach(System.out :: println);

	}
	
	private static List<String> findAllPalindrome(char[] arr) {
		return helper(arr, new Stack<Character>(), 0, new ArrayList<String>());
	}

	private static List<String> helper(char[] arr, Stack<Character> slate, int i, List<String> result) {

		

		// base case
		if (i == arr.length) {
			// backtrack case
			if (isPalindrome(slate) && slate.size() > 0) {
				result.add(slate.toString());
				return result;
			}
			return result;
		}

		// include choice
		slate.push(arr[i]);
		helper(arr, slate, i + 1, result);
		slate.pop();

		// exclude choice
		helper(arr, slate, i + 1, result);

		return result;
	}

	private static boolean isPalindrome(Stack<Character> slate) {

		StringBuilder s = new StringBuilder();
		
		for (Character c : slate) {
			s.append(c);
		}
		String s1 = s.toString();
		String s2 = s.reverse().toString();

		return s1.equals(s2);
	}

}
