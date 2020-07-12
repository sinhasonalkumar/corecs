package corecs.sorting;

public class MergeSorter {

	public static void main(String[] args) {

		int[] arr = { 9, 5, 3, 4,10,1,2 };

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		sort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	public static void sort(int[] arr) {
		 sortHelper(arr, 0, arr.length -1);
	}

	private static void sortHelper(int[] arr, int start, int end) {

		if (start == end) {
			return ;
		}
		
		int mid = (start + end) / 2;

		sortHelper(arr, start, mid);
		sortHelper(arr, mid + 1, end);

		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		int leftSubArrayStartPointer = start;
		int rightSubArrayStartPointer = mid + 1;
		
		int[] sortedMergedArray = new int[end+1];
		int sortedArrayIndex = start;
		
		while(leftSubArrayStartPointer <= mid && rightSubArrayStartPointer <= end) {
			
			if(arr[leftSubArrayStartPointer] <= arr[rightSubArrayStartPointer]) {
				sortedMergedArray[sortedArrayIndex] = arr[leftSubArrayStartPointer];
				leftSubArrayStartPointer ++;
			}else {
				sortedMergedArray[sortedArrayIndex] = arr[rightSubArrayStartPointer];
				rightSubArrayStartPointer ++;
			}
			sortedArrayIndex ++;
		}
		
		while(leftSubArrayStartPointer <= mid) {
			sortedMergedArray[sortedArrayIndex] = arr[leftSubArrayStartPointer];
			leftSubArrayStartPointer ++;
			sortedArrayIndex ++;
		}
		
		while(rightSubArrayStartPointer <= end) {
			sortedMergedArray[sortedArrayIndex] = arr[rightSubArrayStartPointer];
			rightSubArrayStartPointer ++;
			sortedArrayIndex ++;
		}
		
		copySortedArrayBack(arr, sortedMergedArray,start,end);

	}

	private static void copySortedArrayBack(int[] arr, int[] sortedMergedArray, int start, int end) {
		
		while(start <=  end ) {
			arr[start] = sortedMergedArray[start];
			start++;
		}
		
		
	}

}
