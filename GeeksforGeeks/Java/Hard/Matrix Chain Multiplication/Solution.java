class Solution {
    
    private static int matrix(int i, int j, int[] arr, int[][] dp) {
        if(i == j)  
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int minimum = (int) (1e9);
            
        for(int k=i;k<=j-1;k++) { 
            int steps = (arr[i - 1] * arr[k] * arr[j]) + matrix(i, k, arr, dp) + matrix(k + 1, j, arr, dp);
            
            minimum = Math.min(minimum, steps);
        }
        
        return dp[i][j] = minimum;
    }
    
    private static int matrix(int i, int j, int[] arr) {
        if(i == j)  
            return 0;
            
        int steps = 0;
        int minimum = (int) (1e9);
            
        for(int k=i;k<=j-1;k++) { 
            steps = (arr[i - 1] * arr[k] * arr[j]) + matrix(i, k, arr) + matrix(k + 1, j, arr);
            
            minimum = Math.min(minimum, steps);
        }
        
        return minimum;
    }
    
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return matrix(1, n - 1, arr, dp);
    }
}