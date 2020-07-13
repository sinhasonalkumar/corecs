package corecs.sorting.kthlargest;

import java.util.concurrent.ThreadLocalRandom;

public class KthLargestElementInArrayQuickSelectV1 {
	
	
	public static void main(String[] args) {
		
		// 1,2,3,4,5,9,10
		int[] arr = {10,3,1,4,9,2,5};
		
		Integer kthLargestElement = quickSelectKthlargestElement(arr, 3);
		
		System.out.println("kthLargestElement -> " + kthLargestElement);
	}

	public static Integer quickSelectKthlargestElement(int[] arr, int k) {
		
		Integer startIndex = 0;
		
		Integer endIndex = arr.length -1;
		
		int kIndex = k-1;
		
		return helper(arr, kIndex, startIndex, endIndex);
		
	}
	
	public static Integer helper(int[] arr, int kIndex , Integer startIndex, Integer endIndex) {
		
		
		if(startIndex > endIndex) {
			return null;
		}

		int randomIndex = ThreadLocalRandom.current().nextInt(startIndex, endIndex+1);
		
		int pivotElement = arr[randomIndex];
		
		swap(arr, randomIndex, startIndex);
		
		int smallerValuePointer = startIndex;
		int largerValuePointer = startIndex;
		
		largerValuePointer++;
		
		while(largerValuePointer <= endIndex) {
			
			if(pivotElement > arr[largerValuePointer]) {
				largerValuePointer++;
			}else {
				smallerValuePointer++;
				swap(arr, smallerValuePointer, largerValuePointer);
				largerValuePointer++;
			}
		}
		
		swap(arr, startIndex, smallerValuePointer);
		
		if(kIndex == smallerValuePointer) {
			return arr[smallerValuePointer];
		
		}else {
			if(kIndex > smallerValuePointer) {
				return helper(arr, kIndex, smallerValuePointer +1 , endIndex);
			}else {
				return helper(arr, kIndex, startIndex , smallerValuePointer-1);
			}
		}
	}

	private static void swap(int[] arr, int p1, int p2) {
		
		int tmp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = tmp;
		
	}

	
}
