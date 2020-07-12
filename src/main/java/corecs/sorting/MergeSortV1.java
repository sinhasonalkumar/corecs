package corecs.sorting;

public class MergeSortV1 {
	
	
	public static void main(String[] args) {
		int[] arr = { 9, 5, 3, 4,10,1,2 };

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		arr = mergesort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
	
	public static int[] mergesort(int[] inputArray) {
		
		int length = inputArray.length;
		
		if (length == 1) {
			return inputArray;
		}
			
		int mid = length / 2;
		
		int[] leftSubArray = new int[mid];
		
		int[] rightSubArray = new int[length - mid];
		
		for (int i = 0; i < leftSubArray.length; i++) {
			leftSubArray[i] = inputArray[i];
		}
			
		for (int i = 0; i < rightSubArray.length; i++) {
			rightSubArray[i] = inputArray[mid + i];
		}
			
		return merge(mergesort(leftSubArray), mergesort(rightSubArray));
	}
	
	

	private static int[] merge(int[] leftSubArray, int[] rightSubArray) {
		
		int[] mergedSortedArray = new int[leftSubArray.length + rightSubArray.length];
		
		int leftSubArrayStratingIndex = 0;
		int rightSubArrayStratingIndex = 0;
		
		int mergedSortedArrayStartingIndex = 0;
		
		while(leftSubArrayStratingIndex < leftSubArray.length  && rightSubArrayStratingIndex < rightSubArray.length) {
			
			if(leftSubArray[leftSubArrayStratingIndex] <= rightSubArray[rightSubArrayStratingIndex]) {
				mergedSortedArray[mergedSortedArrayStartingIndex] = leftSubArray[leftSubArrayStratingIndex];
				leftSubArrayStratingIndex ++;
			}else {
				mergedSortedArray[mergedSortedArrayStartingIndex] = rightSubArray[rightSubArrayStratingIndex];
				rightSubArrayStratingIndex ++;
			}
			mergedSortedArrayStartingIndex ++;
		}
		
		while(leftSubArrayStratingIndex < leftSubArray.length) {
			mergedSortedArray[mergedSortedArrayStartingIndex] = leftSubArray[leftSubArrayStratingIndex];
			leftSubArrayStratingIndex ++;
			mergedSortedArrayStartingIndex++;
		}
		
		while(rightSubArrayStratingIndex < rightSubArray.length) {
			mergedSortedArray[mergedSortedArrayStartingIndex] = rightSubArray[rightSubArrayStratingIndex];
			rightSubArrayStratingIndex ++;
			mergedSortedArrayStartingIndex ++;
		}
		
		return mergedSortedArray;
	}

	

	

}
