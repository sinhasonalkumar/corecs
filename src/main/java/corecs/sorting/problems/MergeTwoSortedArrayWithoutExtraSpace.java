package corecs.sorting.problems;

/*
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6] 
 */

public class MergeTwoSortedArrayWithoutExtraSpace {
	
	public static void main(String[] args) {
		
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		
		mergeSortedArrays(nums1, nums2);
		
		System.out.println("Nums1 After Merging");
		
		for (int i : nums1) {
			System.out.print(i + "\t");
		}
	}

	public static void mergeSortedArrays(int[] nums1, int[] nums2) {
		
		
		int pointer2 = nums2.length -1;
		
		int pointer1 = pointer2;
		
		int runningPointer = nums1.length -1;
		
		
		while(pointer1 >= 0 && pointer2 >= 0) {
			
			if(nums1[pointer1] > nums2[pointer2]) {
				
				nums1[runningPointer] = nums1[pointer1];
				pointer1 --;
				runningPointer --;
			}else {
				nums1[runningPointer] = nums2[pointer2];
				pointer2 --;
				runningPointer --;
			}
		}
		
		while(pointer1 >= 0) {
			nums1[runningPointer] = nums1[pointer1];
			pointer1 --;
			runningPointer --;
		}
		
		while(pointer2 >= 0) {
			nums1[runningPointer] = nums2[pointer2];
			pointer2 --;
			runningPointer --;
		}
	}
	
}
