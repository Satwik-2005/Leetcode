class Solution {

    // 1 -> buy, 0 -> sell
    private int maximumProfit(int index, int buy, int[] prices) {
        if(index >= prices.length)
            return 0;
        
        int profit = 0;

        if(buy == 1)
            profit = Math.max(
                -prices[index] + maximumProfit(index + 1, 0, prices),
                maximumProfit(index + 1, 1, prices)
            );

        else 
            profit = Math.max(
                prices[index] + maximumProfit(index + 1, 1, prices),
                maximumProfit(index + 1, 0, prices)
            );

        return profit;
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;

        return maximumProfit(0, 1, prices);
    }
}