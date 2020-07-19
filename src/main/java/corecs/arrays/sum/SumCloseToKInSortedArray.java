package corecs.arrays.sum;

import java.util.Arrays;

/*

Given a sorted array and a number x, find the pair in array whose sum is closest to x
Given a sorted array and a number x, find a pair in array whose sum is closest to x.
Examples:

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
  
  
 */

public class SumCloseToKInSortedArray {
	
	public static void main(String[] args) {
		
		//int[] arr = {10, 22, 28, 29, 30, 40};
		//int k = 54;
		
		//int[] arr = {1, 3, 4, 7, 10};
		//int k = 15;
		
		int[] arr = {1, 3, 4, 7, 10};
		int k = 14;

		
		Integer[] result = findSumCloseToK(arr, k);
		
		for (Integer curResult : result) {
			
			System.out.print(curResult + "\t");
		}
	}

	public static Integer[] findSumCloseToK(int[] arr, int k) {

		Integer[] result = null;
		
		Integer minDiff = Integer.MAX_VALUE;
		
		Integer num1 = null;
		
		Integer num2 = null;
		
		Integer leftpointer = 0;
		
		Integer rightPointer = arr.length -1;
		
		Arrays.sort(arr);
		
		Integer curDiff;
		
		Integer curSum;
		
		while(leftpointer < rightPointer) {
			
			curSum = arr[leftpointer] + arr[rightPointer];
			
			if(curSum == k) {
				result = new Integer[2];
				result[0] = arr[leftpointer];
				result[1] = arr[rightPointer];
				
				return result;
			}
			
			curDiff = Math.abs(k - curSum);
			
			//Math.min(minDiff, curDiff);
			if(curDiff < minDiff) {
				
				minDiff = curDiff;
				num1 = arr[leftpointer];
				num2 = arr[rightPointer]; 
			}
			
			if(curSum > k) {
				rightPointer --;
			}else {
				leftpointer ++;
			}
		}
		
		result = new Integer[2];
		result[0] = num1;
		result[1] = num2;
		
		return result;
	}

}
