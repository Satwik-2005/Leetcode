class Solution {
    
    private int coinChange(int index, int target, int[] coins, int[][] dp) {
        if(index == 0) {
            if((target % coins[0]) == 0)
                return target / coins[0];
                
            else 
                return (int) (1e8);
        }
        
        if(dp[index][target] != -1)
            return dp[index][target];
        
        int notTake = 0 + coinChange(index - 1, target, coins, dp);
        int take = Integer.MAX_VALUE;
        
        if(coins[index] <= target)  
            take = 1 + coinChange(index, target - coins[index], coins, dp);
            
        return dp[index][target] = Math.min(take, notTake);
    }
    
    public int minCoins(int coins[], int sum) {
        // code here
        int n = coins.length;
        
        int[][] dp = new int[n][sum + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        int value = coinChange(n - 1, sum, coins, dp);
        
        return (value != 1e8) ? value : -1;
    }
}