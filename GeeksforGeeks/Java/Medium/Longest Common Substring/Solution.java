class Solution {
    public int longCommSubstr(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int ans = 0;

        int[][] dp = new int[n + 1][m + 1];

        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=m;j++) dp[0][j] = 0;

        for(int index1=1;index1<=n;index1++) {
            for(int index2=1;index2<=m;index2++) {
                char ch1 = s1.charAt(index1 - 1);
                char ch2 = s2.charAt(index2 - 1);

                if(ch1 == ch2) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                    ans = Math.max(ans, dp[index1][index2]);
                }

                else
                    dp[index1][index2] = 0;
            }
        }

        return ans;
    }
}