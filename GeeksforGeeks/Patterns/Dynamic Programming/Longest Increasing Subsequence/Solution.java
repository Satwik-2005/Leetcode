class Solution {
    
    private int LIS(int index, int previousIndex, int[] arr, int n, int[][] dp) {
        if(index == n)
            return 0;
            
        if(dp[index][previousIndex + 1] != -1)
            return dp[index][previousIndex + 1];
            
        int len = 0 + LIS(index + 1, previousIndex, arr, n, dp);
        
        if(previousIndex == -1  ||  arr[index] > arr[previousIndex])
            len = Math.max(len, 1 + LIS(index + 1, index, arr, n, dp));
            
        return dp[index][previousIndex + 1] = len;
    }
    
    private int LIS(int index, int previousIndex, int[] arr, int n) {
        if(index == n)
            return 0;
            
        int len = 0 + LIS(index + 1, previousIndex, arr, n);
        
        if(previousIndex == -1  ||  arr[index] > arr[previousIndex])
            len = Math.max(len, 1 + LIS(index + 1, index, arr, n));
            
        return len;
    }
    
    public int lis(int arr[]) {
        // code here
        int n = arr.length;
        
        int[][] dp = new int[n][n + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return LIS(0, -1, arr, n, dp);
    }
}