class Solution {

    int MOD = 1_000_000_007;

    public int ways(int x, int y) {
        // code here
        int dp[][] = new int[x+2][y+2];

        dp[1][1] = 1;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(i == 1 && j == 1) continue;
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
            }
        }

        return dp[x+1][y+1];
    }
}