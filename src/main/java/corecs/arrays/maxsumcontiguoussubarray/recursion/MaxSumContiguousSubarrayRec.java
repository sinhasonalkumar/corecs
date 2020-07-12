package corecs.arrays.maxsumcontiguoussubarray.recursion;

public class MaxSumContiguousSubarrayRec {
	
	/*
	 
	  Given an integer array nums, find the contiguous subarray (containing at least one number) which
	  has the largest sum and return its sum.
	  Example:

			Input: [-2,1,-3,4,-1,2,1,-5,4],
			Output: 6
			Explanation: [4,-1,2,1] has the largest sum = 6.
			
			
		Follow up:
		If you have figured out the O(n) solution, 
		try coding another solution using the divide and conquer approach, which is more subtle.	
	  
	 */
	
	public static void main(String[] args) {
		
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
		int maxSum = findMaxSum(arr);
		
		System.out.println("Max Sum Of Contiguous Subarray -> " + maxSum);
	}

	public static int findMaxSum(int[] arr) {
		
		return helper(arr, 0, Integer.MIN_VALUE,0);
	}
	
	public static int helper(int[] arr, int i, int maxSum, int maxSofar) {
		
		if(i == arr.length -1) {
			return maxSum;
		}
		
		maxSofar = Math.max(arr[i], maxSofar + arr[i]);
		maxSum = Math.max(maxSum, maxSofar);
		
		return helper(arr, i+1, maxSum, maxSofar);
	}
}
