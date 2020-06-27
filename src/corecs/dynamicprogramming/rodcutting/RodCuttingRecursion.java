package corecs.dynamicprogramming.rodcutting;

public class RodCuttingRecursion {
	
	
	public static void main(String[] args) {
		
		int[] priceList = {1,3,3,8,8,10};
		
		int maxSellingPrice = findMaxSellingPrice(priceList);
		
		System.out.println("############################");
		System.out.println("maxSellingPrice -> "+ maxSellingPrice);
		System.out.println("############################");
	}
	
	public static int findMaxSellingPrice(int[] priceList) {
		
		
		return helper(priceList, priceList.length);
	}
	
	public static int helper(int[] priceList, int curLengthOfRodToCut) {
		
		int maxSellingPrice = Integer.MIN_VALUE;
		
		int sellingPriceOfCurrentCutChoice = Integer.MIN_VALUE;
		
		//Base Case 1
		if(curLengthOfRodToCut == 0) {
			return 0;
		}
		
		//Base Case 2
		if(curLengthOfRodToCut == 1) {
			return priceList[0];
		}
		
		// Recursion Condition : Choices to cut rod into pieces of various length from 1 to curLengthOfRodToCut
		
		for(int curCutLengthChoice = 1; curCutLengthChoice <= curLengthOfRodToCut ; curCutLengthChoice ++) {
			
			sellingPriceOfCurrentCutChoice = priceList[(curCutLengthChoice - 1)] + helper(priceList, (curLengthOfRodToCut - curCutLengthChoice));
			
			maxSellingPrice = Math.max(maxSellingPrice, sellingPriceOfCurrentCutChoice);
		}
		
		return maxSellingPrice;
	}
}
