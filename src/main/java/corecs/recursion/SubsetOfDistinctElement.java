package corecs.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubsetOfDistinctElement {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		
		List<String> subsets = findAllSubsets(arr);
		
		subsets.stream().forEach(System.out :: println);
	}
	
	
	private static List<String> findAllSubsets(int[] arr) {
		return helper(arr, new Stack<Integer>(), 0, new ArrayList<String>());
	}
	
	
	private static List<String> helper(int[] arr, Stack<Integer> slate, int i, List<String> result) {
		
		if(i == arr.length) {
			result.add(slate.toString());
			return result;
		}
		
		//Include a[i]
		slate.push(arr[i]);
		helper(arr, slate, i+1, result);
		slate.pop();
		
		//Exclude a[i]
		helper(arr, slate, i+1, result);
		
		return result;
	}

}
