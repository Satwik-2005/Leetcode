class Solution {
    
    private int maximumChocolates(int row, int col1, int col2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(col1 < 0  ||  col1 >= m  ||  col2 < 0  ||  col2 >= m)
            return (int) (-1e8);
            
        if(dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        
        if(row == n - 1) {
            if(col1 == col2)
                return grid[row][col1];
                
            else
                return grid[row][col1] + grid[row][col2];
        }
        
        int max = 0;
        
        for(int i=-1;i<=1;i++) {
            for(int j=-1;j<=1;j++) {
                if(col1 == col2) {
                    max = Math.max(
                            max, 
                            grid[row][col1] + 
                            maximumChocolates(row + 1, col1 + i, col2 + j, grid, dp)
                        );
                }
                        
                else  {
                    max = Math.max(
                            max,
                            grid[row][col1] + grid[row][col2] +
                            maximumChocolates(row + 1, col1 + i, col2 + j, grid, dp)
                        );
                }
            }
        }
        
        return dp[row][col1][col2] = max;
    }
    
    private int maximumChocolates(int row, int col1, int col2, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(col1 < 0  ||  col1 >= m  ||  col2 < 0  ||  col2 >= m)
            return (int) (-1e8);
            
        if(row == n - 1) {
            if(col1 == col2)
                return grid[row][col1];
                
            else
                return grid[row][col1] + grid[row][col2];
        }
        
        int max = 0;
        
        for(int i=-1;i<=1;i++) {
            for(int j=-1;j<=1;j++) {
                if(col1 == col2) {
                    max = Math.max(
                            max, 
                            grid[row][col1] + 
                            maximumChocolates(row + 1, col1 + i, col2 + j, grid)
                        );
                }
                        
                else  {
                    max = Math.max(
                            max,
                            grid[row][col1] + grid[row][col2] +
                            maximumChocolates(row + 1, col1 + i, col2 + j, grid)
                        );
                }
            }
        }
        
        return max;
    }
    
    public int maxChocolate(int grid[][]) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][][] dp = new int[n][m][m];
        
        for(int[][] mat : dp)
            for(int[] row : mat)
                Arrays.fill(row, -1);
        
        return maximumChocolates(0, 0, m - 1, grid, dp);
    }
}