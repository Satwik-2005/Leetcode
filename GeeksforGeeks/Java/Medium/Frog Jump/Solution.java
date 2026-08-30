class Solution {
    
    private int frogJump(int[] height, int n, int[] dp) {
        if(n == 0)
            return 0;
            
        if(dp[n] != -1)
            return dp[n];
            
        int left = frogJump(height, n - 1, dp) + Math.abs(height[n - 1] - height[n]);
        int right = Integer.MAX_VALUE;
        
        if(n > 1)
            right = frogJump(height, n - 2, dp) + Math.abs(height[n - 2] - height[n]);
            
        return dp[n] = Math.min(left, right);
    }
    
    private int frogJump(int[] height, int n) {
        if(n == 0)
            return 0;
            
        int left = frogJump(height, n - 1) + Math.abs(height[n - 1] - height[n]);
        int right = Integer.MAX_VALUE;
        
        if(n > 1)
            right = frogJump(height, n - 2) + Math.abs(height[n - 2] - height[n]);
            
        return Math.min(left, right);
    }
    
    int minCost(int[] heights) {
        // code here
        int n = heights.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, 0);
        
        for(int i=1;i<n;i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            
            if(i > 1)
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
                
            dp[i] = Math.min(left, right);
        }
        
        return dp[n - 1];
    }
}