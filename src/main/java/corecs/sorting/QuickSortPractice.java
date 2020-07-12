package corecs.sorting;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSortPractice {
	
	public static void main(String[] args) {
		int[] arr = { 9, 5, 3, 4,10,1,2 };

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
	
	public static int[] quickSort(int[] arr) {
		
		quickSortHelper(arr, 0, arr.length-1);
		
		return arr;
	}

	private static void quickSortHelper(int[] arr, int start, int end) {
		
		
		if(start >= end) {
			return;
		}
		
		int randomIndex = ThreadLocalRandom.current().nextInt(start, end);
		
		int pivotElement = arr[randomIndex];
		
		swap(arr, start, randomIndex);
		
		int smallerPointer = start;
		int biggerPointer = start;
		
		biggerPointer++;
		
		while(biggerPointer <= end) {
			
			if(arr[biggerPointer] > pivotElement) {
				biggerPointer++;
			}else {
				smallerPointer++;
				swap(arr, smallerPointer, biggerPointer);
				biggerPointer++;
			}
		}
		
		swap(arr, start, smallerPointer);
		
		quickSortHelper(arr, start, smallerPointer - 1);
		
		quickSortHelper(arr, smallerPointer + 1, end);
		
	}
	
	private static void swap(int[] arr, int index1, int index2) {
		
		int tmp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = tmp;
	}

}
