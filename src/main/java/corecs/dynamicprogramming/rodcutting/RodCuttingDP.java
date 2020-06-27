package corecs.dynamicprogramming.rodcutting;

public class RodCuttingDP {
	
	public static void main(String[] args) {
		
		//int[] priceList = {1,3,3,8,8,10};
		
		int[] priceList = {1,5,3,2};
		
		int maxSellingPrice = findMaxSellingPrice(priceList);
		
		System.out.println("############################");
		System.out.println("maxSellingPrice -> "+ maxSellingPrice);
		System.out.println("############################");
	}

	public static int findMaxSellingPrice(int[] priceList) {
		
		int lengthOfLength = priceList.length;
		
		int[] dpTable = new int[lengthOfLength+1];
		
		int maxPriceForCurRodCutChoice = Integer.MIN_VALUE;
		
		int maxPriceForCurRodLenth = Integer.MIN_VALUE;
		
		// Known Problems -> Base case from recursion version of it
		dpTable[0] = 0;
		//dpTable[1] = priceList[0]; optional
		
		for(int curRodLength = 1; curRodLength <= lengthOfLength; curRodLength++) {
			
			for(int curRodCutChoice = 1; curRodCutChoice <= curRodLength ; curRodCutChoice++) {
				
				maxPriceForCurRodCutChoice = priceList[curRodCutChoice-1] + dpTable[curRodLength-curRodCutChoice];
				
				maxPriceForCurRodLenth = Math.max(maxPriceForCurRodLenth, maxPriceForCurRodCutChoice);
			}
			dpTable[curRodLength] = maxPriceForCurRodLenth;
			
			maxPriceForCurRodCutChoice = Integer.MIN_VALUE;
			maxPriceForCurRodLenth = Integer.MIN_VALUE;
		}
		
		return dpTable[lengthOfLength];
	}
}
