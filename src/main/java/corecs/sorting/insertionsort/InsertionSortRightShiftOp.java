package corecs.sorting.insertionsort;

// This impl is better as we have to copy one value in contrast to bubble swap way of insertion sort
// as we bubble swap way of insertion sort we have to do 3 copy op in do swap op. 
public class InsertionSortRightShiftOp {
	
	
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
		
		int tmp;
		int j;
		
		// assuming first element is already sorted arr[0] as one element is always sorted. 
		// Now sorting all elements from arr[2] to arr[n-1] one by one by putting arr[i] to right place in left side. i = 1 to n-1
		// sorted[0] | unsorted[n-1] 
		
		for(int i=1 ; i < arr.length ; i++) {
			
			tmp = arr[i];
			
			j = i;
			
			while(j > 0 && tmp < arr[j-1]) {
				// shift/copy to right meaning copy arr[j-1] to arr[j]. 
				//Now arr[j-1] is vacant meaning available to place and a potential correct place for tmp.
				arr[j] = arr[j-1];
				j--;
			}
			
			arr[j] = tmp;
		}
	}
	
}
