package corecs.dynamicprogramming.ropecutting;

public class RopeCuttingRecursionV2 {
	
	public static void main(String[] args) {
		
		System.out.println(maxProduct(5));
	}
	
	
	public static int maxProduct(int n) {
		
		return helper(n, true);
	}
	
	public static int helper(int lengthOfRope, boolean isRoot) {
		
		if(lengthOfRope == 0) {
		  return 1;
		}	
		
		int maxProduct = Integer.MIN_VALUE;
		
		int maxProductSoFar = Integer.MIN_VALUE;	
		
		int choiceToCutUntil;
		
		if(isRoot) {
			choiceToCutUntil = lengthOfRope -1;
		}else {
			choiceToCutUntil = lengthOfRope;	
		}
		
		for(int cut=1; cut <= choiceToCutUntil ; cut++) {
			
			maxProductSoFar = cut * helper(lengthOfRope - cut, false);
			
			maxProduct = Math.max(maxProduct, maxProductSoFar);
		}
		
		return maxProduct;
		
	}

}
