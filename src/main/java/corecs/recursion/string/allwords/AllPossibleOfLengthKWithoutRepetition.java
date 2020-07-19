package corecs.recursion.string.allwords;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Repeations are not allowed
// order does not matter
public class AllPossibleOfLengthKWithoutRepetition {
	
	public static void main(String[] args) {
		
		char[] arr = {'a','b','c'};
		
		int k = 3;
		
		List<String> allPossibleWords = findAllPossibleWords(arr, k);
		
		allPossibleWords.forEach(System.out :: println);
	}

	
	public static List<String> findAllPossibleWords(char[] arr, int k){
		
		List<String> result = new ArrayList<String>();
		
		helper(arr, k, 0, new Stack<Character>(), result);
		
		return result;
		
	}
	
	
	// startIndex is starting index of desired word of length k not staring pos of arr
	public static void helper(char[] arr, int k, int startIndex, Stack<Character> slate, List<String> result) {
		
		if(startIndex == k) {
			result.add(charStackToString(slate));
			return;
		}
		
		
		for(int i= startIndex ; i< arr.length ; i++) {
			
			slate.push(arr[i]);
			swap(arr, i, startIndex);
			
			helper(arr, k, startIndex+1, slate, result);
			
			swap(arr, i, startIndex);
			slate.pop();
			
		}
	}
	
	public static void swap(char[] arr, int idx1, int idx2) {
		
		char tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	public static String charStackToString(Stack<Character> stack) {
		
		StringBuffer s = new StringBuffer();
		
		for (Character curChar : stack) {
			s.append(curChar);
		}
		
		return s.toString();
	}
}
