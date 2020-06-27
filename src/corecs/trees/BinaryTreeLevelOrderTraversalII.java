package corecs.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

	/*
	 	07. Binary Tree Level Order Traversal II
Easy

1154

203

Add to List

Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
   10
   / \
  9  30
    /  \
   15   35
return its bottom-up level order traversal as:
[
  [15,35],
  [9,30],
  [10]
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
	
	public static List<List<Integer>> bfs(BinarySearchTree bst) {
		return helper(bst, new ArrayList<List<Integer>>());
	}

	private static List<List<Integer>> helper(BinarySearchTree root, ArrayList<List<Integer>> result) {
		
		Queue<BinarySearchTree> q = new LinkedList<BinarySearchTree>();
		
		q.add(root);
		
		List<Integer> levelNodesList = null;
		BinarySearchTree curNode = null;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			levelNodesList = new ArrayList<Integer>();
			
			for(int i = 0 ; i < size ; i++) {
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
		
		Collections.reverse(result);
		
		return result;
	}

}
