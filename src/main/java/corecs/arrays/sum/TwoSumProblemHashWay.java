package corecs.arrays.sum;

import java.util.HashSet;
import java.util.Set;

public class TwoSumProblemHashWay {

	public static void main(String[] args) {

		int[] arr = { 10, 1, 4, 15, 12, 5, 13, 0, 6 };

		//int sum = 20;
		int sum = 10;

		int[] result = findTwoSumProblem(arr, sum);

		System.out.print("Result -> Sum " + sum + " : ");
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static int[] findTwoSumProblem(int[] arr, int sum) {

		int[] result = new int[2];

		Set<Integer> diffSet = new HashSet<Integer>();

		int curDiff;

		for (Integer curElement : arr) {

			curDiff = sum - curElement;

			if (diffSet.contains(curElement)) {
				result[0] = curElement;
				result[1] = curDiff;
				return result;
			}else {
				diffSet.add(curDiff);
			}
		}

		return result;
	}
}
