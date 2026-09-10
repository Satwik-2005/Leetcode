class Solution {
    
    private static int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=m;j++) dp[0][j] = 0;

        for(int index1=1;index1<=n;index1++) {
            for(int index2=1;index2<=m;index2++) {
                char ch1 = s1.charAt(index1 - 1);
                char ch2 = s2.charAt(index2 - 1);

                if(ch1 == ch2)
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];

                else
                    dp[index1][index2] = 0 + Math.max(
                        dp[index1 - 1][index2],
                        dp[index1][index2 - 1]
                    );
            }
        }

        return dp[n][m];
    }
    
    private static String reverse(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i); 
        }

        return reversed;
    }

    public static int longestPalinSubseq(String s) {
        // code here
        String str = reverse(s);

        return lcs(s, str);
    }
    
    static int findMinInsertions(String s) {
        // code here
        return s.length() - longestPalinSubseq(s);
    }
}