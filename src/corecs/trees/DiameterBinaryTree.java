package corecs.trees;

public class DiameterBinaryTree {
	
/*
	100
   /  \
  90  200
 / \    
50 60

Return 3 

*/
	

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		int[] numbers = { 100, 60, 200, 50, 90 };
		// int[] numbers = {1,3,2};

		bst.add(numbers);
		
		findDiameter(bst);
		
		System.out.println(finalDiameter);

	}

	private static int finalDiameter =0;
	
	public static int findDiameter(BinarySearchTree root) {
		return helper(root);
	}

	private static int helper(BinarySearchTree root) {

		int leftHeight = 0;
		int rightHeight = 0;
		int rootHeight = 0;
		int diameter = 0;
		

		if (root == null) {
			return 0;
		}

		if (root.getLeft() != null) {
			leftHeight = helper(root.getLeft());
			diameter = leftHeight +  1;
		}

		if (root.getRight() != null) {
			rightHeight = helper(root.getRight());
			diameter += rightHeight +  1;
		}
		
		finalDiameter = Math.max(diameter, finalDiameter);
		
		if (isLeaf(root)) {
			return 0;
		}		

		rootHeight = Math.max(leftHeight , rightHeight) + 1;
		return rootHeight;
	}

	public static boolean isLeaf(BinarySearchTree node) {
		return node.getLeft() == null && node.getRight() == null;
	}
}
