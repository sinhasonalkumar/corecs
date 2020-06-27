package corecs.dynamicprogramming.ropecutting;

public class RopeCuttingDP {
	
	/*
	 
	 	Constraints:

				2 <= length of the rope <= 111
				You have to cut at least once.
			    Length of the rope, lengths of all parts are all positive integers.
	 
	 */
	

	public static void main(String[] args) {

		System.out.println(max_product_from_cut_pieces(5));

	}

	/*
	 * Complete the max_product_from_cut_pieces function below.
	 */
	public static long max_product_from_cut_pieces(int n) {

		long[] dpTable = new long[n + 1];
		
		// Base Case Rope of length 0. Means no rope. So maxProduct = 0 
		dpTable[0] = 0;
		
		// Base Case Rope of length 1 : This can not cut further. So max product is 1
		dpTable[1] = 1;
		

		long maxProduct = Long.MIN_VALUE;
		long maxProductSoFar = Integer.MIN_VALUE;

		// For rope length 2 to n
		for (int curRopeLength = 2; curRopeLength <= n; curRopeLength++) {

			for (int cut = 1; cut <= curRopeLength; cut++) {
				
				// to cover max product between cases like 4 -> 2-1-1 and 4 -> 2-2 
				maxProductSoFar = Math.max(cut * (curRopeLength - cut), cut * dpTable[curRopeLength - cut]);
				
				// Max product between among all choices to cut
				maxProduct = Math.max(maxProduct, maxProductSoFar);
			}

			dpTable[curRopeLength] = maxProduct;

			maxProductSoFar = Integer.MIN_VALUE;

		}
		return dpTable[n];

	}
}
