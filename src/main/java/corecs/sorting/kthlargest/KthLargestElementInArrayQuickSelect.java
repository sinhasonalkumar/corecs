package corecs.sorting.kthlargest;

import java.util.concurrent.ThreadLocalRandom;

public class KthLargestElementInArrayQuickSelect {
	
	private static Integer kthLargestElement = null;
	
	public static void main(String[] args) {
		
		// 1,2,3,4,5,9,10
		int[] arr = {10,3,1,4,9,9,2,5};
		
		quickSelectKthlargestElement(arr, 3);
		
		System.out.println("kthLargestElement -> " + kthLargestElement);
	}

	public static Integer quickSelectKthlargestElement(int[] arr, int k) {
		
		Integer startIndex = 0;
		
		Integer endIndex = arr.length -1;
		
		int kIndex = k-1;
		
		helper(arr, kIndex, startIndex, endIndex);
		
		return kthLargestElement;
		
	}
	
	public static void helper(int[] arr, int kIndex , Integer startIndex, Integer endIndex) {
		
		
		if(startIndex > endIndex) {
			return;
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
			kthLargestElement =  arr[smallerValuePointer];
			return;
		}else {
			if(kIndex > smallerValuePointer) {
				helper(arr, kIndex, smallerValuePointer +1 , endIndex);
			}else {
				helper(arr, kIndex, startIndex , smallerValuePointer-1);
			}
		}
	}

	private static void swap(int[] arr, int p1, int p2) {
		
		int tmp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = tmp;
		
	}

	
}
