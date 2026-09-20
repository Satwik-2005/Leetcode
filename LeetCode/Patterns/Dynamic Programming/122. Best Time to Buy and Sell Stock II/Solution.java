class Solution {

    private int maximumProfit(int index, int buy, int[] prices, int[][] dp) {
        if(index >= prices.length)
            return 0;

        if(dp[index][buy] != -1)
            return dp[index][buy];
        
        int profit = 0;

        if(buy == 1)
            profit = Math.max(
                -prices[index] + maximumProfit(index + 1, 0, prices, dp),
                maximumProfit(index + 1, 1, prices, dp)
            );

        else 
            profit = Math.max(
                prices[index] + maximumProfit(index + 1, 1, prices, dp),
                maximumProfit(index + 1, 0, prices, dp)
            );

        return dp[index][buy] = profit;
    }

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
        int[][] dp = new int[n][2];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return maximumProfit(0, 1, prices, dp);
    }
}