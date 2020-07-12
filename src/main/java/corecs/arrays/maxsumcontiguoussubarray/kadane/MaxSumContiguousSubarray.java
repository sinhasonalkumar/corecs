package corecs.arrays.maxsumcontiguoussubarray.kadane;

public class MaxSumContiguousSubarray {

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
		
		int maxSum = Integer.MIN_VALUE;
		int maxSumSoFar = 0;
		
		for(int i=0; i< arr.length ; i++) {
			
			maxSumSoFar = Math.max(arr[i],(maxSumSoFar + arr[i]));
			maxSum = Math.max(maxSum, maxSumSoFar);
		}
		
		return maxSum;
	}
}
