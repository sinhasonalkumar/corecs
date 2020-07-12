package corecs.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortV4 {
	
	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(4,0,1,3,2);

		System.out.print("Input UnSorted Array :: ");
		for (int i : arr) {
			System.out.print(i + "\t");
		}

		List<Integer> result = merge_sort(arr);

		System.out.println("\n");

		System.out.print("Output Sorted Array :: ");
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here
        
        if(arr == null) {
            return arr;
        }
        
        int length = arr.size();
        
        if(length <= 1) {
            return arr;
        }
        
        int mid = length/2; 
        
        List<Integer> leftArray = arr.subList(0, mid); 
        List<Integer> rightArray = arr.subList(mid, length); 
        
        return merge(merge_sort(leftArray), merge_sort(rightArray));

    }
    
    private static List<Integer> merge(List<Integer> arr1, List<Integer> arr2 ) {
        
        int arr1StartPointer = 0;
        int arr2StartPointer = 0;
        
        int arr1Length = arr1.size();
        int arr2Length = arr2.size();
        
        List<Integer> mergedList = new ArrayList<>();
        
        while(arr1StartPointer < arr1Length && arr2StartPointer < arr2Length) {
            if(arr1.get(arr1StartPointer) <= arr2.get(arr2StartPointer)) {
                mergedList.add(arr1.get(arr1StartPointer));
                arr1StartPointer ++;
            }else{
                mergedList.add(arr2.get(arr2StartPointer));
                arr2StartPointer ++;
            }
        }
        
        while(arr1StartPointer < arr1Length) {
            mergedList.add(arr1.get(arr1StartPointer));
            arr1StartPointer ++;
        }
        
        while(arr2StartPointer < arr2Length) {
            mergedList.add(arr2.get(arr2StartPointer));
            arr2StartPointer ++;
        }
        
        return mergedList;
    }
}
