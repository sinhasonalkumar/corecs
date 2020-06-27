package corecs.recursion.bst;

public class BSTCountWithNNodes {

	public static void main(String[] args) {
		long count = how_many_BSTs(3);

		System.out.println(count);
	}

	static long how_many_BSTs(int n) {
		return helper(n);
	}

	static long helper(int n) {

		// base case 
		// With one node there is only 1 possible BST
		// With zero node there is only 1 possible BST
		if (n== 0 || n == 1 ) {
			return 1;
		}

		long count = 0;

		// n choices as root
		for (int i = 0; i < n; i++) {

			// left subTree
			long leftSubBSTCount = helper(i);

			// right subtree
			long rightSubBSTCount = helper((n - 1) - i);

			// leftSubBSTCount*rightSubBSTCount : all combination of left and right
			// so total count will sum of all such combination
			count += leftSubBSTCount * rightSubBSTCount;
		}

		return count;
	}

}
