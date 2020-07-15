package corecs.sorting.problems;

/*
 
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] 
such that sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60],

 your program should be able to find that the subarray lies between the indexes 3 and 8.

2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], 

  your program should be able to find that the subarray lies between the indexes 2 and 5.
  
 */

public class SmallestWindowSorting {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		
		//int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		
		printSmallestWindowToSort(arr);
	}
	
	public static void printSmallestWindowToSort(int[] arr) {
		
		
		int resultWindowStart;
		int resultWindowEnd;
		
		int maxSofarFromLeftIndex;
		int minSoFarFromRightIndex;
		
		int localMin;
		int localMax;
		
		int i = 0;
		
		while(i < arr.length -1 && arr[i] < arr[i+1]) {
			i++;
		}
		
		maxSofarFromLeftIndex = i;
		
		i= arr.length -1;
		
		while(i > 0 && arr[i] > arr[i-1]) {
			i--;
		}
		
		minSoFarFromRightIndex = i;
		
		
		// Result window to sort.
		// If we sort this window then element left to resultWindowStart should be smaller.Otherwise we have to expand resultWindowStart to left
		// Similarly If we sort this window then element right to resultWindowEnd should be bugger.Otherwise we have to expand resultWindowStart to right
		resultWindowStart = maxSofarFromLeftIndex;
	    resultWindowEnd = minSoFarFromRightIndex;
		
		// Find local min and max value between window maxSofarIndex and minSoFarIndex
	    // We are finding local min and max value to see if we have to expand the window to left or right to get correct window size to sort
	    localMin = arr[maxSofarFromLeftIndex];
		localMax = arr[maxSofarFromLeftIndex];
		
		for(i=maxSofarFromLeftIndex; i<= minSoFarFromRightIndex; i++) {
			
			if(arr[i] < localMin) {
				
				localMin = arr[i];
			}
			
			if(arr[i] > localMax) {
				
				localMax = arr[i];
			}
		}
		
		// Check if element left to resultWindowStart is smaller.Otherwise expand its boundary to left.
		for(i=maxSofarFromLeftIndex-1 ; i >=0; i-- ) {
			
			if(arr[i] > localMin ) {
				resultWindowStart --;
			}else {
				break;
			}
		}
		
		// Check if element right to resultWindowEnd is bigger.Otherwise expand its boundary to right.
		for(i=minSoFarFromRightIndex+1 ; i< arr.length; i++) {
			
			if(arr[i] < localMax) {
				resultWindowEnd ++;
			}else {
				break;
			}
		}
		
		System.out.println("Smallest Window To Sort is from Index ->  " + resultWindowStart + " to " + resultWindowEnd);
		
	}

}
