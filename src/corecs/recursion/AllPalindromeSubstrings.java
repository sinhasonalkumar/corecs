package corecs.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromeSubstrings {


	/*
	 *  input= "aab"
	 *  output : [
	 *  			["aa","b"],
	 *  			["a","a","b"]
	 *  		 ]
	 */
	
	public static List<String> findAllPlaindromeSubString(String input) {
		
		return null;
	}
	
	private static List<String> helper(char[] arr, int i) {
		
		List<String> result = new ArrayList<String>();
		
		if(i == arr.length) {
			return result;
		}
	return null;	
	}
	
	private List<String> getAllSubStrings(char[] arr, int runningIndex, int size) {
		
		List<String> result = new ArrayList<String>();
		
		//if()
		
		for (int i = 1; i <= arr.length; i++) {
			result.addAll(getAllSubStringOfSize(arr, 0, i));
		}
		
		return  null;
	}
	
	private List<String> getAllSubStringOfSize(char[] arr, int runningIndex, int size) {
		
		List<String> result = new ArrayList<String>();
		
		if(runningIndex == arr.length) {
			return result;
		}
		
		String tmp = "";
		for(int j = runningIndex;  j >= size ; j++) {
			tmp = tmp + arr[j]; 
		}
		
		return getAllSubStringOfSize(arr, runningIndex + 1, size);
	}

}
