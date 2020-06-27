package corecs.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UppercaseLowerCaseCombination {

	public static void main(String[] args) {
		List<String> result = findAllCombination("a1b2");

		for (String string : result) {
			System.out.println(string);
		}
	}

	private static List<String> findAllCombination(String str) {
		return helper(str.toCharArray(), new Stack<Character>(), 0, new ArrayList<String>());
	}

	private static List<String> helper(char[] str, Stack<Character> slate, int i, List<String> result) {

		if (i == str.length) {
			result.add(slate.toString());
			return result;
		}

		if (Character.isDigit(str[i])) {

			slate.push(str[i]);
			helper(str, slate, i + 1, result);
			slate.pop();

		} else {

			slate.push(str[i]);
			helper(str, slate, i + 1, result);
			slate.pop();

			slate.push(Character.toUpperCase(str[i]));
			helper(str, slate, i + 1, result);
			slate.pop();
		}
		return result;
	}

}
