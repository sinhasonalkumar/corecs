package corecs.arrays.sum;

import java.util.Arrays;

public class TwoSumProblemSlidingWindow {
	
	public static void main(String[] args) {
		
		int[] arr = {10,1,4,15,12,5,13,0,6};
		
		int sum = 20;
		
		Integer[] result = findTwoSumProblem(arr, sum);
		
		System.out.print("Result -> Sum " + sum + " : " );
		if(result != null) {
			for (int i : result) {
				System.out.print(i + "\t");
			}	
		}
		
	}

	public static Integer[] findTwoSumProblem(int[] arr, int sum) {
		
		Integer[] result = null;
		
		Arrays.sort(arr);
		
		int leftPointer = 0;
		
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
				rightPointer --;
			}else {
				leftPointer++;
			}
		}
		
		return result;
	}
}
