class Solution {
    
    private int rodCutting(int index, int rodLength, int[] price, int[][] dp) {
        if(index == 0) 
            return rodLength * price[0];
            
        if(dp[index][rodLength] != -1)
            return dp[index][rodLength];
            
        int notTake = 0 + rodCutting(index - 1, rodLength, price, dp);
        int take = Integer.MIN_VALUE;
        int rod = index + 1;
        
        if(rod <= rodLength)
            take = price[index] + rodCutting(index, rodLength - rod, price, dp);
            
        return dp[index][rodLength] = Math.max(take, notTake);
    }
    
    private int rodCutting(int index, int rodLength, int[] price) {
        if(index == 0) 
            return rodLength * price[0];
            
        int notTake = 0 + rodCutting(index - 1, rodLength, price);
        int take = Integer.MIN_VALUE;
        int rod = index + 1;
        
        if(rod <= rodLength)
            take = price[index] + rodCutting(index, rodLength - rod, price);
            
        return Math.max(take, notTake);
    }
    
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return rodCutting(n - 1, n, price, dp); 
    }
}