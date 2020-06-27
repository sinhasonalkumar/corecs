package corecs.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationBySum {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		List<String> allCombinationBySum = findCombinationBySum(arr, 4);
		
		allCombinationBySum.stream().forEach(System.out :: println);
	}
	
	private static List<String> findCombinationBySum(int[] arr, int sum){
		
		return helper(arr, sum, new Stack<Integer>(), 0, 0, new ArrayList<String>());
	}

	private static List<String> helper(int[] arr, int sum, Stack<Integer> slate, int i, int currentSum, List<String> result) {

		// backtracking case
		if (sum <= currentSum) {
			if (sum == currentSum) {
				result.add(slate.toString());
			}
			return result;
		}

		// base case
		if (i == arr.length) {
			return result;
		}

		// Include choice
		slate.push(arr[i]);
		helper(arr, sum, slate, i + 1, currentSum + arr[i], result);
		slate.pop();

		// Exclude Case
		helper(arr, sum, slate, i + 1, currentSum, result);

		return result;

	}

}
