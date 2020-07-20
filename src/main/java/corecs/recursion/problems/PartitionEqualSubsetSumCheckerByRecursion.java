package corecs.recursion.problems;

/*

Given a non-empty array containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
  
 */


public class PartitionEqualSubsetSumCheckerByRecursion {
	
	
	public static void main(String[] args) {
		
		int[] arr = {1, 5, 11, 5};
		
		// int[] arr = {11, 5, 1, 5};
		
		//int[] arr = {1, 2, 3, 5};
		
		boolean result = isEqualSubSetSum(arr);
		
		System.out.println(result);
	}

	
	public static boolean isEqualSubSetSum(int[] arr) {
		
		int totalSum = 0;
		
		for (int i : arr) {
			totalSum += i;
		}
		
		if(totalSum % 2 == 0) {
			
			int equalPartionSum = totalSum/2;
			return helper(arr, equalPartionSum, 0, 0);
		}else {
			return false;
		}
		
		
	}
	
	public static boolean helper(int[] arr, int sum, int start, int runningSum) {
		
		boolean result = false;
		
		
		if(sum == runningSum) {
			return true;
		}
		
		if(start == arr.length) {
			return false;
		}
		
		result = helper(arr, sum, start+1, runningSum);
		
		if(result) {
			return true;
		}else {
			result = helper(arr, sum, start+1, runningSum + arr[start]);
			
			if(result) {
				return true;
			}
		}
		
		return result;
		
	}
}
