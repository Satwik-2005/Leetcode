class Solution {
    
    private int count(int n, int[] dp) {
        if(n == 0)
            return 1;
        
        if(n == 1)
            return 1;
            
        if(dp[n] != -1)
            return dp[n];
            
        int left = count(n - 1, dp);
        int right = count(n - 2, dp);
        
        return dp[n] = left + right;
    }
    
    public int countWays(int n) {
        // code here
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
        
        return count(n, dp);
    }
}