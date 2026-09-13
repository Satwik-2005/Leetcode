class Solution {

     private int distinctSubsequences(int index1, int index2, String s, String t, int[][] dp) {
        if(index2 < 0)
            return 1;

        if(index1 < 0)
            return 0;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(s.charAt(index1) == t.charAt(index2))
            return distinctSubsequences(index1 - 1, index2 - 1, s, t, dp) + distinctSubsequences(index1 - 1, index2, s, t, dp);

        return dp[index1][index2] = distinctSubsequences(index1 - 1, index2, s, t, dp);
    }

    private int distinctSubsequences(int index1, int index2, String s, String t) {
        if(index2 < 0)
            return 1;

        if(index1 < 0)
            return 0;

        if(s.charAt(index1) == t.charAt(index2))
            return distinctSubsequences(index1 - 1, index2 - 1, s, t) + distinctSubsequences(index1 - 1, index2, s, t);

        return distinctSubsequences(index1 - 1, index2, s, t);
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return distinctSubsequences(n - 1, m - 1, s, t, dp);
    }
}