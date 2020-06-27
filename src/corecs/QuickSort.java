package corecs;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
	
	
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
	
	
	public static void quickSort(int[] inputArray) {
		quickSortHelper(inputArray, 0,inputArray.length -1);
	}
	

	public static void quickSortHelper(int[] inputArray, int start , int end) {
		
		
		if(start >= end) {
			return ;
		}
		
		int randomIndex = ThreadLocalRandom.current().nextInt(start , end);
		
		
		int pivotNo = inputArray[randomIndex];
		inputArray[randomIndex] = inputArray[start];
		inputArray[start] = pivotNo;
		
		int smallerNoPointer = start;
		int biggerNoPointer = start + 1;
		
		int tmp;
		
		while(biggerNoPointer <= end) {
			
			if(inputArray[biggerNoPointer] <= pivotNo) {
				smallerNoPointer ++;
				tmp = inputArray[smallerNoPointer];
				inputArray[smallerNoPointer] = inputArray[biggerNoPointer];
				inputArray[biggerNoPointer] = tmp;
			}
			
			biggerNoPointer ++;
		}
	   
	   inputArray[start] = inputArray[smallerNoPointer];
	   inputArray[smallerNoPointer] = pivotNo;
	   
	   quickSortHelper(inputArray, start, (smallerNoPointer -1));
	   
	   quickSortHelper(inputArray, (smallerNoPointer + 1), end);
		
		
	}

}
