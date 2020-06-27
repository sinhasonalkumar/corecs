package corecs.trees;


public class BuildBinarySearchTree {

	
	public static void main(String[] args) {
		
		BinarySearchTree bt = new BinarySearchTree();
		
		int[] numbers = {2,1,3,4};
		//int[] numbers = {1,3,2};
		
		bt.add(numbers);
	}
	
}


class BinarySearchTree {
	
	private BinarySearchTree left;
	
	private BinarySearchTree right;
	
	private Integer value;
	
	
	public BinarySearchTree() {}
	
	  
	
	public BinarySearchTree getLeft() {
		return left;
	}



	public void setLeft(BinarySearchTree left) {
		this.left = left;
	}



	public BinarySearchTree getRight() {
		return right;
	}



	public void setRight(BinarySearchTree right) {
		this.right = right;
	}



	public Integer getValue() {
		return value;
	}



	public void setValue(Integer value) {
		this.value = value;
	}



	public BinarySearchTree(int value) {
		this.value = value;
	}
	
	public void add(int[] numbers) {
		
		for (int number : numbers) {
			addHelper(this, number);	
		}
	}
	
	public void add(int number) {
		addHelper(this, number);
	}
	
	private void addHelper(BinarySearchTree root, int number) {
		
		if(root.value == null) {
			root.value = number;
			
		}else {
			if(number <= root.value) {
				if(root.left != null) {
					addHelper(root.left, number);
				}else {
					root.left = new BinarySearchTree(number);
				}
				
			}else {
				if(root.right != null) {
					addHelper(root.right, number);
				}else {
					root.right = new BinarySearchTree(number);
				}
			}
		}
		
	}
	
	
	public String toString() {
		return this.value != null ? this.value.toString() : null;
	}
	
}
