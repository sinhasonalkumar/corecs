package corecs.trees;

//  All Tests case failed
public class UniValSubTreeCountV1 {

	private static int count;

	static int findSingleValueTrees(TreeNode root) {
		count = 0;
		if (root != null) {
			helper(root);
		}
		return count;
	}

	static boolean helper(TreeNode root) {
		Boolean result = false;
		Boolean leftResult = false;
		Boolean rightResult = false;

		if (root.left_ptr != null) {
			leftResult = helper(root.left_ptr);
		} else {
			leftResult = true;
		}

		if (root.right_ptr != null) {
			rightResult = helper(root.right_ptr);
		} else {
			rightResult = true;
		}

		if (root.left_ptr == null && root.right_ptr == null) {
			// result = leftResult && leftResult;
			result = true;
		} else if (root.left_ptr != null && root.right_ptr == null) {
			result = leftResult && root.left_ptr.val == root.val;
		} else if (root.left_ptr == null && root.right_ptr != null) {
			result = rightResult && root.right_ptr.val == root.val;
		} else if (root.left_ptr != null && root.right_ptr != null) {
			result = leftResult && rightResult && root.left_ptr.val == root.val && root.right_ptr.val == root.val;
		}

		if (result) {
			count++;
		}

		return result;
	}

	private static class TreeNode {
		public int val;
		public TreeNode left_ptr;
		public TreeNode right_ptr;
	}
}
