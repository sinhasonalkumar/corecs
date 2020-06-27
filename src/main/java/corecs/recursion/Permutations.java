package corecs.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		List<String> allPermutations = findAllPermutations(arr);
		allPermutations.stream().forEach(System.out :: println);
	}
	
	private static List<String> findAllPermutations(int[] arr) {
		return helper(arr, new Stack<Integer>(), 0, new ArrayList<String>());
	}

	private static List<String> helper(int[] arr, Stack<Integer> slate, int i, List<String> result) {
		
		//Base Case
		if(i == arr.length) {
			result.add(slate.toString());
			return result;
		}
		
		// Choices
		for(int currentChoicePickedPointer = i ; currentChoicePickedPointer < arr.length; currentChoicePickedPointer++) {
			
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
