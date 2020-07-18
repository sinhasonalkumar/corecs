package corecs.arrays.sum;

import java.util.Arrays;

public class ThreeSumProblem {
	
	public static void main(String[] args) {
		
		int[] arr = { 10, 1, 4, 15, 12, 5, 13, 0, 6 };

		int sum = 25;

		Integer[] result = findThreeSumProblem(arr, sum);

		System.out.print("Result -> Sum " + sum + " : ");
		if (result != null) {
			for (int i : result) {
				System.out.print(i + "\t");
			}
		}
	}

	public static Integer[] findThreeSumProblem(int[] arr, int sum) {
		
		int newSum;
		
		Integer[] twoSumResult = null;
		Integer[] threeSumResult = null;
		
		for(int i= 0; i< arr.length; i++) {
			
			newSum = sum - arr[i];
			swap(arr, i, 0);
			
			twoSumResult = findTwoSumProblem(arr, newSum, 1);
			
			if(twoSumResult != null) {
				threeSumResult = new Integer[3];
				threeSumResult[0] = twoSumResult[0];
				threeSumResult[1] = twoSumResult[1];
				threeSumResult[2] = arr[i];
				
				return threeSumResult;
			}
		}
		
		return threeSumResult;
	}
	
	public static Integer[] findTwoSumProblem(int[] arr, int sum, int startIndex) {
		
		Integer[] result = null;
		
		Arrays.sort(arr, startIndex, arr.length);
		
		int leftPointer = startIndex;
		int rightPointer = arr.length -1;
		
		int curSum;
		
		while(leftPointer < rightPointer) {
			
			curSum = arr[leftPointer] + arr[rightPointer];
			
			if(curSum == sum) {
				result = new Integer[2];
				result[0] = arr[leftPointer];
				result[1] = arr[rightPointer];
				return result;
			}
			
			if(curSum > sum) {
				rightPointer--;
			}else {
				leftPointer ++;
			}
		}
		
		return result;
	}
	
	public static void swap(int[] arr, int idx1, int idx2) {
		
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		
	}
}
