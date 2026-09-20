class Solution {

    int sellAndBuyStocks(int index , int buy , int sell , int[] prices , int n , int[][][] dp) {
        if(sell == 0)
            return 0;

        if(index == n)
            return 0;

        if(dp[index][buy][sell] != -1)
            return dp[index][buy][sell];

        if(buy == 1)
            return dp[index][buy][sell] = Math.max(
                0 + sellAndBuyStocks(index + 1 , 1 , sell , prices , n , dp) , 
                -prices[index] + sellAndBuyStocks(index + 1 , 0 , sell , prices , n , dp)
            );

        else 
            return dp[index][buy][sell] = Math.max(
                0 + sellAndBuyStocks(index + 1 , 0 , sell , prices , n , dp) ,
                prices[index] + sellAndBuyStocks(index + 1 , 1 , sell - 1 , prices , n , dp)
            );
    }

    int sellAndBuyStocks(int index , int buy , int sell , int[] prices , int n) {
        if(sell == 0)
            return 0;

        if(index == n)
            return 0;

        if(buy == 1)
            return Math.max(
                0 + sellAndBuyStocks(index + 1 , 1 , sell , prices , n) , 
                -prices[index] + sellAndBuyStocks(index + 1 , 0 , sell , prices , n)
            );

        else 
            return Math.max(
                0 + sellAndBuyStocks(index + 1 , 0 , sell , prices , n) ,
                prices[index] + sellAndBuyStocks(index + 1 , 1 , sell - 1 , prices , n)
            );
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {

                    if (buy == 1) 
                        curr[buy][cap] = Math.max(
                            after[1][cap], 
                            -prices[index] + after[0][cap]
                        );
                    
                    else 
                        curr[buy][cap] = Math.max(
                            after[0][cap],
                            prices[index] + after[1][cap - 1]
                        );

                }
            }

            after = curr;
        }

        return after[1][2];
    }
}