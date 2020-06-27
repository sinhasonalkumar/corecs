package corecs.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidBracketsCombination {
	
	public static void main(String[] args) {
		List<String> allValidBracesCombination = findAllValidBracesCombination(4);
		
		allValidBracesCombination.stream().forEach(System.out :: println);
	}

	private static List<String> findAllValidBracesCombination(int n) {
		return helper(n, new Stack<Character>(), 0, 0, new ArrayList<String>());
	}

	private static List<String> helper(int n, Stack<Character> slate, int leftBrabceCount, int rightBraceCount,
			List<String> result) {

		// BackTrack Case
		if (rightBraceCount > leftBrabceCount ) {
			return result;
		}else {
			if(leftBrabceCount == rightBraceCount && slate.size() == 2 * n) {
				result.add(slate.toString());	
			}
		}

		// Base Case
		if (slate.size() == 2 * n) {
			return result;
		}

		// Case -1 : left brance '('
		slate.push('(');
		helper(n, slate,leftBrabceCount + 1, rightBraceCount, result);
		slate.pop();

		// Case -2 : right brance ')'
		slate.push(')');
		helper(n, slate, leftBrabceCount, rightBraceCount + 1, result);
		slate.pop();

		return result;
	}

}
