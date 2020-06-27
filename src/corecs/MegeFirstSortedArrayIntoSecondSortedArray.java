package corecs;

public class MegeFirstSortedArrayIntoSecondSortedArray {

	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 5 };
		int[] arr2 = { 2, 4, 6, 0, 0, 0 };

		merger_first_into_second(arr1, arr2);

		for (int i : arr2) {
			System.out.println(i);
		}
	}

	static void merger_first_into_second(int[] arr1, int[] arr2) {
		/*
		 * Write your code here.
		 */

		int arr1StartPointer = 0;
		int arr2StartPointer = 0;

		int arr1End = arr1.length;
		int arr2End = (arr2.length - arr1.length);

		int[] ma = new int[arr2.length];
		int mp = 0;

		while (arr1StartPointer < arr1End && arr2StartPointer < arr2End) {
			if (arr1[arr1StartPointer] < arr2[arr2StartPointer]) {
				ma[mp] = arr1[arr1StartPointer];
				arr1StartPointer++;
			} else {
				ma[mp] = arr2[arr2StartPointer];
				arr2StartPointer++;
			}
			mp++;
		}

		while (arr1StartPointer < arr1End) {
			ma[mp] = arr1[arr1StartPointer];
			arr1StartPointer++;
			mp++;
		}

		while (arr2StartPointer < arr2End) {
			ma[mp] = arr2[arr2StartPointer];
			arr2StartPointer++;
			mp++;
		}

		//arr2 = ma;

		for(int i = 1 ; i< ma.length; i++) {
			arr2[i] = ma[i];
		}

	}

}
