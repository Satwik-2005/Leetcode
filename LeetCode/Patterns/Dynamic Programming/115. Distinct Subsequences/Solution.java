class Solution {

    int distinctSubsequences(int index1 , int index2 , String s , String t , int[][] dp) {
        if(index2 < 0)
            return 1;

        if(index1 < 0)
            return 0;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(s.charAt(index1) == t.charAt(index2))
            return dp[index1][index2] = distinctSubsequences(index1 - 1 , index2 - 1 , s , t , dp) + distinctSubsequences(index1 - 1 , index2 , s , t , dp);

        return dp[index1][index2] = distinctSubsequences(index1 - 1 , index2 , s , t , dp);
    }

    int distinctSubsequences(int index1 , int index2 , String s , String t) {
        if(index2 < 0)
            return 1;

        if(index1 < 0)
            return 0;

        if(s.charAt(index1) == t.charAt(index2))
            return distinctSubsequences(index1 - 1 , index2 - 1 , s , t) + distinctSubsequences(index1 - 1 , index2 , s , t);

        return distinctSubsequences(index1 - 1 , index2 , s , t);
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n + 1];

        prev[0] = 1;

        for(int i=1;i<=m;i++) {
            int[] curr = new int[n + 1];

            curr[0] = 1;

            for(int j=1;j<=n;j++) {
                if(s.charAt(i - 1)  ==  t.charAt(j - 1))
                    curr[j] = prev[j - 1] + prev[j];

                else
                    curr[j] = prev[j];
            }

            prev = curr;
        }

        return prev[n];
    }
}