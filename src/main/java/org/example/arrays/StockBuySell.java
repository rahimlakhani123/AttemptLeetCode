package org.example.arrays;

public class StockBuySell {
    public static void main(String[] args) {
        StockBuySell bs = new StockBuySell();
        var profit = bs.findMaxProfit(new int[]{1, 5, 3, 1, 2, 8});
        System.out.println(profit);
    }

    public int findMaxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit = maxProfit + prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}
