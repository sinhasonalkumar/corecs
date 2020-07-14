package corecs.sorting.quicksort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3way {

	public static void main(String[] args) {
		
		int[] arr = { 9, 5, 5, 3, 4, 10, 9, 1, 2, 3 };
		
		//int[] arr = { 9, 5, 3, 4,10,1,2 };

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		quickSort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
	
	public static void quickSort(int[] arr) {
		
		helper(arr, 0, arr.length -1);
	}
	
	public static void helper(int[] arr, int startIndex, int endIndex) {
		
		if(startIndex >= endIndex) {
			return;
		}
		
		int randomIndex = ThreadLocalRandom.current().nextInt(startIndex, endIndex);
		
		int pivotElement = arr[randomIndex];
		
		int smallerNoPointer = startIndex;
		int largerNoPointer = endIndex;
		int equalNoPointer = startIndex;
		
		while(equalNoPointer <= largerNoPointer) {
			
			if(arr[equalNoPointer] == pivotElement) {
				equalNoPointer++;
			}else {
				if(arr[equalNoPointer] > pivotElement) {
					swap(arr, equalNoPointer, largerNoPointer);
					largerNoPointer --;
				}else {
					if(arr[equalNoPointer] < pivotElement) {
						swap(arr, equalNoPointer, smallerNoPointer);
						equalNoPointer++;
						smallerNoPointer++;
					}
				}
			}
		}
		
		helper(arr, startIndex, smallerNoPointer-1);
		
		helper(arr, largerNoPointer+1, endIndex);
		
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
		
	}
}
