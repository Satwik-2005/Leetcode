class Solution {

    int profit = 0;

    int maxProfitOfStocks(int index , int buy , int[] prices , int n , int[][] dp) {
        if(index == n)
            return 0;

        if(dp[index][buy] != -1)
            return dp[index][buy];

        if(buy == 1)
            profit = Math.max(-prices[index] + maxProfitOfStocks(index + 1 , 0 , prices , n , dp) , 
                            0 + maxProfitOfStocks(index + 1 , 1 , prices , n , dp));

        else
            profit = Math.max(prices[index] + maxProfitOfStocks(index + 1 , 1 , prices , n , dp) , 
                            0 + maxProfitOfStocks(index + 1 , 0 , prices , n , dp));

        return dp[index][buy] = profit;
    }

    int maxProfitOfStocks(int index , int buy , int[] prices , int n) {
        if(index == n)
            return 0;

        if(buy == 1)
            profit = Math.max(-prices[index] + maxProfitOfStocks(index + 1 , 0 , prices , n) , 
                            0 + maxProfitOfStocks(index + 1 , 1 , prices , n));

        else
            profit = Math.max(prices[index] + maxProfitOfStocks(index + 1 , 1 , prices , n) , 
                            0 + maxProfitOfStocks(index + 1 , 0 , prices , n));

        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadNotBuy = 0;
        int aheadBuy = 0;

        for(int i=n-1;i>=0;i--) {
            int currNotBuy = Math.max((prices[i] + aheadBuy) , aheadNotBuy);
            int currBuy = Math.max((-prices[i] + aheadNotBuy) , aheadBuy);

            aheadNotBuy = currNotBuy;
            aheadBuy = currBuy;
        }

        return aheadBuy;
    }
}