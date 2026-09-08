class Solution {
    
    private int knapsackVariable(int index, int[] wt, int[] val, int capacity, int[][] dp) {
        if(index == 0) 
            return ((int) (capacity / wt[0])) * val[0];
            
        if(dp[index][capacity] != -1)
            return dp[index][capacity];
            
        int notTake = 0 + knapsackVariable(index - 1, wt, val, capacity, dp);
        int take = 0;
        
        if(wt[index] <= capacity)
            take = val[index] + knapsackVariable(index, wt, val, capacity - wt[index], dp);
            
        return dp[index][capacity] = Math.max(take, notTake);
    }
    
    private int knapsackVariable(int index, int[] wt, int[] val, int capacity) {
        if(index == 0) 
            return ((int) (capacity / wt[0])) * val[0];
            
        int notTake = 0 + knapsackVariable(index - 1, wt, val, capacity);
        int take = 0;
        
        if(wt[index] <= capacity)
            take = val[index] + knapsackVariable(index, wt, val, capacity - wt[index]);
            
        return Math.max(take, notTake);
    }
    
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n + 1][1001];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return knapsackVariable(n - 1, wt, val, capacity, dp);
    }
}