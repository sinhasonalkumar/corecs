package corecs.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class CombinationsBySize {

	public static void main(String[] args) {
		List<String> allComninationOfSize = findAllComninationOfSize(3, 2);
		allComninationOfSize.stream().forEach(System.out::println);
	}

	private static List<String> findAllComninationOfSize(int n, int size) {

		int[] arr = IntStream.range(1, n + 1).toArray();

		return helper(arr, size, new Stack<Integer>(), 0, new ArrayList<String>());
	}

	private static List<String> helper(int[] arr, int size, Stack<Integer> slate, int i, List<String> result) {

		// backtrack constraint
		if (slate.size() == size) {
			result.add(slate.toString());
			return result;
		}

		// Base case
		if (i == arr.length) {
			return result;
		}

		// Include element choice
		slate.push(arr[i]);
		helper(arr, size, slate, i + 1, result);
		slate.pop();

		// Exclude element choice
		helper(arr, size, slate, i + 1, result);

		return result;

	}
}
