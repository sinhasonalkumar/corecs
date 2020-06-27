package corecs.dynamicprogramming.ropecutting;

public class RopeCuttingDPV2 {
	
	
	public static void main(String[] args) {

		System.out.println(max_product_from_cut_pieces(5));

	}

	
	public static long max_product_from_cut_pieces(int n) {
		 
		long[] dpTable = new long[n+1];
		
		// Base Case Rope of length 0. Means no rope. So maxProduct = 1 
		dpTable[0] = 1;

		long maxProduct = Long.MIN_VALUE;
		long maxProductSoFar = Integer.MIN_VALUE;
		
		int choiceToCutRopeUntilLength;

		
		for (int curRopeLength = 1; curRopeLength <= n; curRopeLength++) {
			
			// Because rope has to be cut at least once
			if(curRopeLength == n) {
				choiceToCutRopeUntilLength = n-1;
			}else {
				choiceToCutRopeUntilLength = curRopeLength;
			}

			for (int cut = 1; cut <= choiceToCutRopeUntilLength; cut++) {
				 
				maxProductSoFar = cut * dpTable[curRopeLength - cut];
				
				maxProduct = Math.max(maxProduct, maxProductSoFar);
			}

			dpTable[curRopeLength] = maxProduct;

			maxProductSoFar = Integer.MIN_VALUE;

		}
		return dpTable[n];

	}

}
