class Solution {
    
     private int maxSum(int row, int col, int[][] mat, int n, int m, int[][] dp) {
        if(col < 0  ||  col >= m)
            return (int) (-1e9);
            
        if(row == 0)
            return mat[0][col];
            
        if(dp[row][col] != -1)
            return dp[row][col];
            
        int up = mat[row][col] + maxSum(row - 1, col, mat, n, m, dp);
        int leftDiagonal = mat[row][col] + maxSum(row - 1, col - 1, mat, n, m, dp);
        int rightDiagonal = mat[row][col] + maxSum(row - 1, col + 1, mat, n, m, dp);
        
        return dp[row][col] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
    
    private int maxSum(int row, int col, int[][] mat, int n, int m) {
        if(col < 0  ||  col >= m)
            return (int) (-1e9);
            
        if(row == 0)
            return mat[0][col];
            
        int up = mat[row][col] + maxSum(row - 1, col, mat, n, m);
        int leftDiagonal = mat[row][col] + maxSum(row - 1, col - 1, mat, n, m);
        int rightDiagonal = mat[row][col] + maxSum(row - 1, col + 1, mat, n, m);
        
        return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
    
    public int maximumPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        int maximum = 0;
        
        for(int j=0;j<m;j++)
            maximum = Math.max(maximum, maxSum(n - 1, j, mat, n, m, dp));
            
        return maximum;
    }
}