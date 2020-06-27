package corecs.trees;

// Failing only for 1 of test case
public class CheckBSTV1 {
	
    /*
    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }
*/

/*
    Complete the function below
*/

	static boolean isBST(TreeNode root) {

		if (root != null) {
			return helper(root);
		} else {
			return true;
		}
	}

	private static boolean helper(TreeNode root) {

		boolean leftResult = false;
		boolean rightResult = false;

		if (root.left_ptr != null) {

			leftResult = helper(root.left_ptr);

			if (leftResult && root.val >= root.left_ptr.val) {
				leftResult = true;
			} else {
				leftResult = false;
			}

		} else {
			leftResult = true;
		}

		if (root.right_ptr != null) {

			rightResult = helper(root.right_ptr);

			if (rightResult && root.val <= root.right_ptr.val) {
				rightResult = true;
			} else {
				rightResult = false;
			}

		} else {
			rightResult = true;
		}

		return leftResult && rightResult;

	}

	private static class TreeNode {
		public int val;
		public TreeNode left_ptr;
		public TreeNode right_ptr;
	}

}
