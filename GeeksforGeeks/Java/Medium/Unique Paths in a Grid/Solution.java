class Solution {
    
    private int unique(int row, int col, int[][] grid, int[][] dp) {
        if(row >= 0  &&  col >= 0  &&  grid[row][col] == 1)
            return 0;
        
        if(row == 0  &&  col == 0)
            return 1;
            
        if(row < 0  ||  col < 0)
            return 0;
            
        if(dp[row][col] != -1)
            return dp[row][col];
            
        int up = unique(row - 1, col, grid, dp);
        int left = unique(row, col - 1, grid, dp);
        
        return dp[row][col] = up + left;
    }
    
    private int unique(int row, int col, int[][] grid) {
        if(row >= 0  &&  col >= 0  &&  grid[row][col] == 1)
            return 0;
        
        if(row == 0  &&  col == 0)
            return 1;
            
        if(row < 0  ||  col < 0)
            return 0;
            
        int up = unique(row - 1, col, grid);
        int left = unique(row, col - 1, grid);
        
        return up + left;
    }
    
    public int uniquePaths(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return unique(n - 1, m - 1, grid, dp);
    }
};