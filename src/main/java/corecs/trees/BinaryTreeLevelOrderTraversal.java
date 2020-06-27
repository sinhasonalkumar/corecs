package corecs.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
/*
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    10
   / \
  9  30
    /  \
   15   35
return its level order traversal as:
[
  [10],
  [9,30],
  [15,35]
] 
  
 */
	
	public static void main(String[] args) {
	
		BinarySearchTree bst = new BinarySearchTree();
		
		int[] numbers = {10,9,30,15,35};
		//int[] numbers = {1,3,2};
		
		bst.add(numbers);
		
		List<List<Integer>> bfs = bfs(bst);
		
		for (List<Integer> levelNodes : bfs) {
			System.out.println(levelNodes);
		}
	}
	
	
	public static List<List<Integer>> bfs(BinarySearchTree root) {
		return helper(root, new ArrayList<List<Integer>>());
	}

	private static List<List<Integer>> helper(BinarySearchTree root, ArrayList<List<Integer>> result) {
		
		if(root == null) {
			return result;
		}
		
		Queue<BinarySearchTree> q = new LinkedList<BinarySearchTree>();
		
		q.add(root);
		
		BinarySearchTree curNode = null;
		List<Integer> levelNodesList = null;
		
		while(!q.isEmpty()) {
			
			levelNodesList = new  ArrayList<Integer>();
			
			// Most imp step as size of q is variable within loop. So keep it out take advantage of initial length ( count of all nodes in a level i.e, breadth wise)
			int size = q.size();
			
			for(int i= 0 ; i< size; i++) {
				curNode = q.remove();
				
				levelNodesList.add(curNode.getValue());
				
				if(curNode.getLeft() != null) {
					q.add(curNode.getLeft());
				}
				
				if(curNode.getRight() != null) {
					q.add(curNode.getRight());
				}
			}
			
			result.add(levelNodesList);
			
		}
		
		
		return result;
	}
}
