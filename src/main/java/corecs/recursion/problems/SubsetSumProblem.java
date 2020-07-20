package corecs.recursion.problems;

/*
 
Given a set of non-negative integers, and a value sum,
determine if there is a subset of the given set with sum equal to given sum.
Example:

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
 */

public class SubsetSumProblem {
	
	public static void main(String[] args) {
		
		//int[] arr = {3, 34, 4, 12, 5, 2};
		//int sum = 9;
		
		//int[] arr = {3, 34, 4, 12, 5, 2};
		//int sum = 30;
		//int sum = 16;
		
		int[] arr = {1, 2, 3, 4, 5, 6};
		int sum = 21;
		
		boolean result = find(arr, sum);
		
		System.out.println(result);
		
	}
	
	public static boolean find(int[] arr, int sum) {
		return helper(arr, sum, 0, 0);
	}
	
	public static boolean helper(int[] arr, int sum, int start, int runningSum) {
	
		boolean result = false;
		
		if(runningSum == sum) {
			return true;
		}
		
		if(start == arr.length) {
			return false;
		}
		
		//Exclude
		result = helper(arr, sum, start + 1, runningSum);
		
		if(result) {
			return true;
		}else {
			
			//Include
			result = helper(arr, sum, start + 1, runningSum + arr[start]);
			
			if(result) {
				return true;
			}
		}
		
		return result;
		
	}

}
