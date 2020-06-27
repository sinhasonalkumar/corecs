package corecs.trees;

// 18/19 All test Case Passed
public class UniValSubTreeCountV2 {

	private static int count;

	static int findSingleValueTrees(TreeNode root) {
		count = 0;
		if (root != null) {
			helper(root);
		}
		return count;
	}

	static boolean helper(TreeNode root) {
		Boolean result = true;

		if (root.left_ptr != null) {
			boolean resultLeft = helper(root.left_ptr);

			if (!resultLeft || root.left_ptr.val != root.val) {
				result = false;
			}
		}

		if (root.right_ptr != null) {
			boolean resultRight = helper(root.right_ptr);

			if (!resultRight || root.right_ptr.val != root.val) {
				result = false;
			}
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
