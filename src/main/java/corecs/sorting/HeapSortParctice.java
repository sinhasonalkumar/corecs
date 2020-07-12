package corecs.sorting;
public class HeapSortParctice {
	
	public static int[] heapSort(int[] arr) {

		buildMaxHeap(arr);
		
		//Since this is max heap.So First Element of array is Max Number
		int firstElementIndex = 0;
		int curLastElementIndex = arr.length - 1;
		
		for (; curLastElementIndex >= 0; curLastElementIndex--) {
			//Placing the max element at Index 0 to last Index and last Element to Index 0 for sorting
			// This will disturb max heap property. So we have to heapify
			swap(arr, firstElementIndex, curLastElementIndex);
			//heapify to maintain max heap property
			heapify(arr, curLastElementIndex-1, firstElementIndex);
		}
		return arr;
	}
	private static void heapify(int[] arr, int lastElementIndex, int heapifyElementIndex) {

		int largestPointer = heapifyElementIndex;
		int leftPointer = 2 * heapifyElementIndex + 1;
		int rightPointer = 2 * heapifyElementIndex + 2;

		if (leftPointer <= lastElementIndex && arr[leftPointer] > arr[largestPointer]) {
			largestPointer = leftPointer;
		}

		if (rightPointer <= lastElementIndex && arr[rightPointer] > arr[largestPointer]) {
			largestPointer = rightPointer;
		}

		if (largestPointer != heapifyElementIndex) {
			swap(arr, largestPointer, heapifyElementIndex);
			heapify(arr, lastElementIndex, largestPointer);
		}
	}
	private static void buildMaxHeap(int[] arr) {
		for (int i = (arr.length -1 / 2); i >= 0; i--) {
			heapify(arr, arr.length-1, i);
		}
	}
	private static void swap(int[] arr, int index1, int index2) {

		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;

	}
	
	public static void main(String[] args) {
		//int[] arr = { 9, 5, 3, 4, 10, 1, 2 ,11};
		int[] arr = { 9, 5, 3, 4, 10, 1, 2 };

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		heapSort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

}
