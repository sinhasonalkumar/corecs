package corecs.recursion.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PartitionEqualSubsetSumByRecursion {

	
	public static void main(String[] args) {

		 int[] arr = {1, 5, 11, 5};
		
		 //int[] arr = {11, 5, 1, 5};

		//int[] arr = { 1, 2, 3, 5 };

		Result result = doPartitionEqualSubsetSum(arr);

		if(result != null) {
			System.out.println("Partition1 " + result.partition1);	
			System.out.println("Partition2 " + result.partition2);	
		}else {
			System.out.println("Can not be equally partitioned");
		}
		
		
	}
	
	public static Result doPartitionEqualSubsetSum(int[] arr) {
		
		int totalSum = 0;
		
		for (int curElement : arr) {
			totalSum += curElement;
		}
		
		if(totalSum % 2 == 0) {
			
			int equalPartitionSum = totalSum/2;
			
			Stack<Integer> partitionIndices = new Stack<Integer>();
			
			boolean result = helper(arr, equalPartitionSum, 0, 0, partitionIndices);
			
			if(result) {
				
				List<Integer> partition1 = new ArrayList<Integer>(partitionIndices.size());
				
				List<Integer> partition2 = new ArrayList<Integer>(arr.length - partitionIndices.size());
				
				for(int i = arr.length -1; i>= 0 ; i--) {
					
					if(!partitionIndices.isEmpty() && partitionIndices.peek() == i) {
						partition1.add(arr[i]);
						partitionIndices.pop();
						
					}else {
						partition2.add(arr[i]);
					}
				}
				
				Result partitionResult = new Result(partition1, partition2);
				
				return partitionResult;
				
				
			}else {
				return null;
			}
			
		}else {
			return null;
		}
	}
	
	public static boolean helper(int[] arr, int sum, int start, int sumSofar, Stack<Integer> resultPartionIndexStack) {
		
		boolean result = false;
		
		if(sumSofar == sum) {
			return true;
		}
		
		
		if(start == arr.length) {
			return false;
		}
		
		//Exclude
		result = helper(arr, sum, start+1, sumSofar, resultPartionIndexStack);
		
		if(result) {
			return true;
		}else {
			resultPartionIndexStack.push(start);
			result = helper(arr, sum, start+1, sumSofar+ arr[start], resultPartionIndexStack);
			
			if(result) {
				return true;
			}
			resultPartionIndexStack.pop();
		}
		
		
		
		return result;
	}
}


class Result {
	
	List<Integer> partition1;
	
	List<Integer> partition2;
	
	Result(List<Integer> partition1, List<Integer> partition2) {
	
		this.partition1 = partition1;
		this.partition2 = partition2;
	}
}
