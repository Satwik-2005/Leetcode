class Solution {
    
    private int maxSum(int index, int[] arr) {
        if(index == 0)
            return arr[index];
            
        if(index < 0)
            return 0;
            
        int pick = arr[index] + maxSum(index - 2, arr);
        int nonPick = 0 + maxSum(index - 1, arr);
        
        return Math.max(pick, nonPick);
    }
    
    private int maxSum(int index, int[] arr, int[] dp) {
        if(index == 0)
            return arr[index];
            
        if(index < 0)
            return 0;
            
        if(dp[index] != -1)
            return dp[index];
            
        int pick = arr[index] + maxSum(index - 2, arr, dp);
        int notPick = 0 + maxSum(index - 1, arr, dp);
        
        return dp[index] = Math.max(pick, notPick);
    }
    
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
        
        return maxSum(n - 1, arr, dp);
    }
}