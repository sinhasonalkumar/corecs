package corecs.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllBinaryString {

	public static void main(String[] args) {
		List<String> result = findAllBinaryStrings(3);
		
		for (String string : result) {
			System.out.println(string);
		}

	}

	private static List<String> findAllBinaryStrings(int n) {
		return helper(n, new Stack<Character>(), 0, new ArrayList<String>());
	}

	private static List<String> helper(int n, Stack<Character> slate, int i, List<String> result) {

		if (i == n) {
			result.add(slate.toString());
			return result;
		}

		slate.push('0');
		helper(n, slate, i + 1, result);
		slate.pop();

		slate.push('1');
		helper(n, slate, i + 1, result);
		slate.pop();

		return result;

	}
}
