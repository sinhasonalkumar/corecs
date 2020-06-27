package corecs.trees;

public class KthSmallestNoInBST {

	public static void main(String[] args) {
		BinarySearchTree root = new BinarySearchTree();

		int[] numbers = { 2000, 1000, 3000,8,10,9};
		// int[] numbers = {1,3,2};

		root.add(numbers);

		// 3rd SmallestNO
		int k = 3;

		Integer result = find(root, k);

		System.out.println("-------------------------------------");
		System.out.println("result :: " + result);

	}

	private static int count = 0;
	public static Integer find(BinarySearchTree root, int k) {
		return helperDfsInOrder(root, k).getValue();
	}

	// L RO R
	private static BinarySearchTree helperDfsInOrder(BinarySearchTree root, int k) {
		
		BinarySearchTree leftNode = null;
		BinarySearchTree rightNode = null;

		// base case 
		if (root == null) {
			return null;
		}
		 
		// search in left subtree 
		leftNode = helperDfsInOrder(root.getLeft(), k);
		
		
		// if k'th smallest is found in left subtree, return it 
		if(leftNode != null) {
			return leftNode;
		}
		
		// if current element is k'th smallest, return it 
		count++;
		if (count == k) {
			return root;
		}
		
		
		// else search in right subtree
		rightNode = helperDfsInOrder(root.getRight(), k);

		return rightNode;
	}
}
