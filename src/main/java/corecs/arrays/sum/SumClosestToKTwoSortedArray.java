package corecs.arrays.sum;

/*
 
Find the closest pair from two sorted arrays
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x,
we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

Example:

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50      
Output:  7 and 40

*/


public class SumClosestToKTwoSortedArray {
	
	public static void main(String[] args) {

		int[] arr1 = { 1, 4, 5, 7 };
		int[] arr2 = { 10, 20, 30, 40 };
		//int k = 32;
		
		 int k = 50;

		Integer[] closestSum = findSumClosestToKTwoSortedArray(arr1, arr2, k);

		for (Integer curNo : closestSum) {
			System.out.print(curNo + "\t");
		}
	}
	
	public static Integer[] findSumClosestToKTwoSortedArray(int[] arr1, int[] arr2, int k) {
		
		Integer[] result = null;
		
		Integer leftPointer = 0;
		
		Integer rightPointer = arr2.length -1;
		
		int minDiff = Integer.MAX_VALUE;
		Integer num1 = null;
		Integer num2 = null;
		
		Integer curSum = null;
		Integer curDiff = null;
		
		while(leftPointer < arr1.length && rightPointer >= 0) {
			
			curSum = arr1[leftPointer] + arr2[rightPointer];
			
			if(curSum == k) {
				
				result = new Integer[2];
				result[0] = arr1[leftPointer];
				result[1] = arr2[rightPointer];
				return result;
			}
			
			curDiff = Math.abs(k - curSum);
			
			if(curDiff < minDiff) {
				minDiff = curDiff;
				num1 = arr1[leftPointer];
				num2 = arr2[rightPointer];
			}
			
			if(curSum > k) {
				rightPointer--;
			}else {
				leftPointer++;
			}
		}
		
		result = new Integer[2];
		result[0] = num1;
		result[1] = num2;
		
		return result;
	}

}
