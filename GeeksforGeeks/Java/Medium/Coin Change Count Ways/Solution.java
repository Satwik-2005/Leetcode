class Solution {
    
    private int coinChange(int index, int target, int[] coins, int[][] dp) {
        if(index == 0) {
            if((target % coins[index]) == 0)
                return 1;
            
            else 
                return 0;
        }
        
        if(dp[index][target] != -1)
            return dp[index][target];
            
        int notTake = coinChange(index - 1, target, coins, dp);
        int take = 0;
        
        if(coins[index] <= target)
            take = coinChange(index, target - coins[index], coins, dp);
            
        return dp[index][target] = take + notTake;
    }
    
    private int coinChange(int index, int target, int[] coins) {
        if(index == 0) {
            if((target % coins[index]) == 0)
                return 1;
            
            else 
                return 0;
        }
            
        int notTake = coinChange(index - 1, target, coins);
        int take = 0;
        
        if(coins[index] <= target)
            take = coinChange(index, target - coins[index], coins);
            
        return take + notTake;
    }
    
    public int count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        
        int[][] dp = new int[n][sum + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return coinChange(n - 1, sum, coins, dp);
    }
}