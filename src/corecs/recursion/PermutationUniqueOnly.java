package corecs.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PermutationUniqueOnly {
	
	public static void main(String[] args) {
		int[] arr = {1,1,2};
		Set<String> allUniquePermutation = findAllUniquePermutation(arr);
		allUniquePermutation.stream().forEach(System.out :: println);
	}
	
	private static Set<String> findAllUniquePermutation(int[] arr) {
		return helper(arr, new Stack<Integer>(), 0, new HashSet<String>());
	}

	private static Set<String> helper(int[] arr, Stack<Integer> slate, int i, Set<String> result) {
		
		// Base Case
		if(i == arr.length) {
			result.add(slate.toString());
			return result;
		}
		
		// Choices
		for(int currentChoicePickedPointer = i ; currentChoicePickedPointer < arr.length ; currentChoicePickedPointer++) {
			swap(arr, i, currentChoicePickedPointer);
			slate.push(arr[i]);
			helper(arr, slate, i+1, result);
			
			slate.pop();
			swap(arr, i, currentChoicePickedPointer);
		}
		
		return result;
	}
	
	private static void swap(int arr[], int i , int currentChoicePickedPointer) {
		int tmp = arr[currentChoicePickedPointer];
		arr[currentChoicePickedPointer] = arr[i];
		arr[i] = tmp;
	}
}
