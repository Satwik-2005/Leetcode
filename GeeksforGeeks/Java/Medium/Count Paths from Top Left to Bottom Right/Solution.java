class Solution {
    
    private int distinct(int row, int col, int[][] dp) {
        if(row == 0  &&  col == 0)
            return 1;
            
        if(row < 0  ||  col < 0)
            return 0;
            
        if(dp[row][col] != -1)
            return dp[row][col];
            
        int up = distinct(row - 1, col, dp);
        int down = distinct(row, col - 1, dp);
        
        return dp[row][col] = up + down;
    }
    
    private int distinct(int row, int col) {
        if(row == 0  &&  col == 0)
            return 1;
            
        if(row < 0  ||  col < 0)
            return 0;
            
        int up = distinct(row - 1, col);
        int down = distinct(row, col - 1);
        
        return up + down;
    }
    
    public int numberOfPaths(int m, int n) {
        // code here
        int[][] dp = new int[n][m];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return distinct(n - 1, m - 1, dp);
    }
}