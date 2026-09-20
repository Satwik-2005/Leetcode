class Solution {

    // 1 -> buy, 0 -> sell
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
        int[][] dp = new int[n + 1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int index=n-1;index>=0;index--) {
            for(int buy=0;buy<2;buy++) {
                int profit = 0;

                if(buy == 1)
                    profit = Math.max(
                        -prices[index] + dp[index + 1][0],
                        dp[index + 1][1]
                    );

                else 
                    profit = Math.max(
                        prices[index] + dp[index + 1][1],
                        dp[index + 1][0]
                    );

                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }
}