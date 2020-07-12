package corecs.sorting;
public class HeapSortParctice {
	
	public static int[] heapSort(int[] arr) {

		buildMaxHeap(arr);
		
		//Since this max heap.So First Element of array is Max Number
		int firstElement = 0;
		int curLastIndex = arr.length - 1;
		
		for (; curLastIndex >= 0; curLastIndex--) {
			//Placing the max element at Index 0 to last Index and last Element to Index 0 for sorting
			// This will disturb max heap property. So we have to heapify
			swap(arr, firstElement, curLastIndex);
			//heapify to maintain max heap property
			heapify(arr, curLastIndex, firstElement);
		}
		return arr;
	}
	private static void heapify(int[] arr, int length, int i) {

		int largestPointer = i;
		int leftPointer = 2 * i + 1;
		int rightPointer = 2 * i + 2;

		if (leftPointer < length && arr[leftPointer] > arr[largestPointer]) {
			largestPointer = leftPointer;
		}

		if (rightPointer < length && arr[rightPointer] > arr[largestPointer]) {
			largestPointer = rightPointer;
		}

		if (largestPointer != i) {
			swap(arr, largestPointer, i);
			heapify(arr, length, largestPointer);
		}
	}
	private static void buildMaxHeap(int[] arr) {
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
	}
	private static void swap(int[] arr, int index1, int index2) {

		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;

	}
	
	public static void main(String[] args) {
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
