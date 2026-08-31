class Solution {
    long[] dp;
    public int minCost(int n, int i, int d, int c) {
        // code here
        if(n==0) return 0;
        long dp[] = new long[n+1];
        dp[1] = i;
        for(int x=2;x<=n;++x) {
            if(x%2==0) {
                dp[x] = Math.min(dp[x-1]+i, dp[x/2]+c);
            } else dp[x] = Math.min(dp[x-1]+i, dp[(x+1)/2]+c+d);
        }
        return (int)dp[n];
    }
}