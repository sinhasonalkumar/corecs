package corecs.sorting.quicksort.problem;

public class SortBinaryArrayWithMinSwaps {

	public static void main(String[] args) {
		
		int[] arr = {0,0,1,0,1,0,1,1};
		
		System.out.println("Before Sort");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		
		int minSwap = sortWithMinSwap(arr);
		
		System.out.println("\nAfter Sort");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		
		System.out.println("\nMin Swap -> " + minSwap);
	}
	
	
	public static int sortWithMinSwap(int[] arr) {
		
		int zeroNumberPointer = 0;
		
		int oneNumberPointer = arr.length -1;
		
		int swapCount = 0;
		
		boolean swapResult = false;
		
		
		while(zeroNumberPointer <= oneNumberPointer) {
			
			if(arr[zeroNumberPointer] == 0) {
				zeroNumberPointer++;
			}else {
				
				swapResult = swap(arr, zeroNumberPointer, oneNumberPointer);
				
				if(swapResult) {
					swapCount++;
				}
				
				oneNumberPointer --;
			}
		}
		
		return swapCount;
	}
	
	public static boolean swap(int[] arr, int index1, int index2) {
		
		if(arr[index1] == arr[index2]) {
			return false;
		}
		
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
		
		return true;
	}
}
