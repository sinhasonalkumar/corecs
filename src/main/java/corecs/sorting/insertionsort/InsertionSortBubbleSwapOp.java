package corecs.sorting.insertionsort;

public class InsertionSortBubbleSwapOp {

	
	public static void main(String[] args) {
		int[] arr = { 9, 5, 3, 4,10,1,2 };

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		insertionSort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
	
	public static void insertionSort(int[] arr) {
		
		int j;
		
		for(int i = 1; i< arr.length; i++) {
			
			j=i;
			
			while(j > 0 && arr[j] < arr[j-1]) {
				swap(arr, j, j-1);
				j--;
			}
		}
	}
	
	
	public static void swap(int[] arr, int index1, int index2) {

		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;

	}
}
