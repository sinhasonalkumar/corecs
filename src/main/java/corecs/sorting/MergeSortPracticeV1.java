package corecs.sorting;

public class MergeSortPracticeV1 {
	
	public static void main(String[] args) {
		int[] arr = { 9, 5, 3, 4,10,1,2 };

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		arr = mergeSort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
	
	public static int[] mergeSort(int[] arr) {
		
		return divideAndMergeHelper(arr, 0, arr.length-1);
	}
	
	public static int[] divideAndMergeHelper(int[] arr, int start, int end) {
		
		if(start >= end) {
			int[] last = new int[1];
			last[0] = arr[end];
			return last;
		}
		
		int mid = start + (end - start )/2;
		
		int[] arrLeft = divideAndMergeHelper(arr, start, mid);
		
		int[] arrRight = divideAndMergeHelper(arr, mid+1, end);
		
		return merge(arrLeft, arrRight);
		
	}

	private static int[] merge(int[] arrLeft, int[] arrRight) {
		
		int[] mergedSortedArr = new int[arrLeft.length + arrRight.length];
		
		int l = 0;
		int r = 0;
		int m = 0;
		
		while(l < arrLeft.length && r < arrRight.length) {
			if(arrLeft[l] < arrRight[r]) {
				mergedSortedArr[m] = arrLeft[l];
				l++;
			}else {
				mergedSortedArr[m] = arrRight[r];
				r++;
			}
			m++;
		}
		
		while(l < arrLeft.length) {
			mergedSortedArr[m] = arrLeft[l];
			l++;
			m++;
		}
		
		while(r < arrRight.length) {
			mergedSortedArr[m] = arrRight[r];
			r++;
			m++;
		}
		
		return mergedSortedArr;
	}

}
