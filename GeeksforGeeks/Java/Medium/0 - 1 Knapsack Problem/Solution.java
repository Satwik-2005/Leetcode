class Solution {
    
    private int knapsackProblem(int index, int[] wt, int W, int[] val, int[][] dp) {
        if(index == 0) {
            if(wt[0] <= W)
                return val[0];
                
            else
                return 0;
        }
        
        if(dp[index][W] != -1)
            return dp[index][W];
        
        int notTake = knapsackProblem(index - 1, wt, W, val, dp);
        int take = Integer.MIN_VALUE;
        
        if(wt[index] <= W)
            take = val[index] + knapsackProblem(index - 1, wt, W - wt[index], val, dp);
            
        return dp[index][W] = Math.max(notTake, take);
    }
    
    private int knapsackProblem(int index, int[] wt, int W, int[] val) {
        if(index == 0) {
            if(wt[0] <= W)
                return val[0];
                
            else
                return 0;
        }
        
        int notTake = knapsackProblem(index - 1, wt, W, val);
        int take = Integer.MIN_VALUE;
        
        if(wt[index] <= W)
            take = val[index] + knapsackProblem(index - 1, wt, W - wt[index], val);
            
        return Math.max(notTake, take);
    }
    
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        
        int[][] dp = new int[n][W + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return knapsackProblem(n - 1, wt, W, val, dp);
    }
}
