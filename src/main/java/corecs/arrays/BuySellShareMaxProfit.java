package corecs.arrays;

/*

 121. Best Time to Buy and Sell Stock
  
 Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one. 

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

public class BuySellShareMaxProfit {
	
	public static void main(String[] args) {
		
		//int[] sharePrices = {7,1,5,3,6,4};
		//int[] sharePrices = {7,6,4,3,1};
		int[] sharePrices = {7,2,5,3,1,6};
		
		
		System.out.println("Max-Profit -> " + maxProfit(sharePrices));
	}
	
	public static int maxProfit(int[] sharePrices) {
		
		int maxProfit = 0;
		int minSofar = Integer.MAX_VALUE;
		
		for(int day = 0 ; (day+1) < sharePrices.length ; day++) {
		
			if(sharePrices[day] < sharePrices[day+1]) {
				minSofar = Math.min(sharePrices[day], minSofar);
				maxProfit = Math.max((sharePrices[day+1] - minSofar), maxProfit);
			}
		}
		
		return maxProfit;
	}
}
