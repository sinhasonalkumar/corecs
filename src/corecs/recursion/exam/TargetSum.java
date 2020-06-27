package corecs.recursion.exam;

import java.util.Stack;

/*
 * Possible To Achieve Target Sum?



Given a set of integers and a target value k, find a non-empty subset that sums up to k.



Example One

Input: [2 4 8], k = 6

Output: True

Because 2+4=6.



Example Two

Input: [2 4 6], k = 5

Output: False

Because no subset of numbers from the input sums up to 5.



Notes

Input Parameters: Function has two arguments: an array of integers (their order doesn’t matter) and the target value  k.



Output: Function must return a boolean value.



Constraints:

1 <= size of the input array <= 18
-10^17 <= elements of the array, k <= 10^17


Custom Input

Input Format: First line of input contains integer n, size of arr. Next n lines contain integer elements of arr. Next line contains integer k. If arr = [2, 4, 8] and k = 6, custom input would be:

3

2

4

8

6



Output Format: Valid output consists of a single character on a single line: 0 for False or 1 for True. For input arr = [2, 4, 8] and k = 6, correct output would be:

1
 */

public class TargetSum {
	
	
	public static void main(String[] args) {
		long[] arr = {5,-15,12};
		long k = 2;
		boolean result = check_if_sum_possible(arr, k);
		System.out.println(result);
	}
	
	/*
     * Complete the function below.
     */
    private static boolean check_if_sum_possible(long[] arr, long k) {
        
        return helper(arr,k,new Stack<Long>(),0,0);
    }
    
    private static boolean helper(long[] arr, long k, Stack<Long> slate, int i,long currentSum) {
        
        //base case and backtracking and constraint
    	//Since they are looking for -ve numbers also. So we have traverse through end
        if(i == arr.length) {
            if(currentSum == k && slate.size() > 0) {
                return true;
            }else{
                return false;    
            }
        }
        
        //include choice
        slate.push(arr[i]);
        boolean r1 =  helper(arr, k , slate, i+1, currentSum+arr[i]);
        slate.pop();
        
        //exclude choice
        boolean r2 = helper(arr, k , slate, i+1,currentSum);
        
        return (r1 || r2);
        
    }


}
