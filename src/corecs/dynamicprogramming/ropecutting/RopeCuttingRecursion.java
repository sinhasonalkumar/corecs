package corecs.dynamicprogramming.ropecutting;

public class RopeCuttingRecursion {
	
	public static void main(String[] args) {
		
		System.out.println(maxProduct(4));
	}
	
	
	public static int maxProduct(int n) {
		
		return helper(n);
	}
	
	public static int helper(int lengthOfRope) {
		
		if(lengthOfRope == 0) {
		  return 0;
		}
		
		// Base case : Role of Length 1. It can not be cut further so max product is 1
		if(lengthOfRope == 1) {
		   return 1;
		}
		
		
		int maxProduct = Integer.MIN_VALUE;
		
		int maxProductSoFar = Integer.MIN_VALUE;
	
		 
		
		// All choice to cut the rope from 1 to n-1
		// example a rope of length 4 can be cut into 1->1-3, 2-> 2-2,3 -> 3-1, 4 -> 4-0 (This one is invalid as rope has to be cut at least once)
		for(int cut=1; cut <= lengthOfRope ; cut++) {
			
			//wrong logic as it does not cover max product case for division of length of 4
			//between max of 4-> 2-1-1 and 4 -> 2-2. This will miss 4-> 2-2 case.
			//maxSoFar = cut * helper(lengthOfRope - cut);
			
			maxProductSoFar = Math.max(cut * (lengthOfRope - cut), cut * helper(lengthOfRope - cut));
			
			// Max product between among all choices to cut
			maxProduct = Math.max(maxProduct, maxProductSoFar);
		}
		
		//System.out.println(" Exit Rope size -> " + lengthOfRope   + " -> maxSoFar  " + maxProduct);
		
		return maxProduct;
		
	}

}
