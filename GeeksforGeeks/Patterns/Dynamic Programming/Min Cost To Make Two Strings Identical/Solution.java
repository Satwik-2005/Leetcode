

class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0] = 0;
        for(int j=0;j<=n;j++) dp[0][j] = 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        //System.out.println(dp[m][n]);
        int r1 = (m-dp[m][n])*costS1;
        int r2 = (n-dp[m][n])*costS2;
        return r1+r2;
    }
}