class Solution {
    
    private boolean wildcardPattern(int i, int j, String txt, String pat, int[][] dp) {
        if(i < 0  &&  j < 0)
            return true;

        if(i < 0  &&  j >= 0) {
            for(int k = 0; k <= j; k++)
                if(pat.charAt(k) != '*')
                    return false;
            return true;
        }

        if(j < 0  &&  i >= 0)
            return false;

        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean result;
        if(pat.charAt(j) == txt.charAt(i)  ||  pat.charAt(j) == '?')
            result = wildcardPattern(i - 1, j - 1, txt, pat, dp);
        else if(pat.charAt(j) == '*')
            result = wildcardPattern(i - 1, j, txt, pat, dp) || wildcardPattern(i, j - 1, txt, pat, dp);
        else 
            result = false;

        dp[i][j] = result ? 1 : 0;
        return result;
    }
    
    private boolean wildcardPattern(int i, int j, String txt, String pat) {
        if(i < 0  &&  j < 0)
            return true;

        if(i < 0  &&  j >= 0) {
            for(int k = 0; k <= j; k++)
                if(pat.charAt(k) != '*')
                    return false;
            return true;
        }

        if(j < 0  &&  i >= 0)
            return false;

        if(pat.charAt(j) == txt.charAt(i)  ||  pat.charAt(j) == '?')
            return wildcardPattern(i - 1, j - 1, txt, pat);

        else if(pat.charAt(j) == '*')
            return wildcardPattern(i - 1, j, txt, pat)  ||  wildcardPattern(i, j - 1, txt, pat);

        else 
            return false;
    }
    
    public boolean wildCard(String txt, String pat) {
        // code here
        int n = txt.length();
        int m = pat.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return wildcardPattern(n - 1, m - 1, txt, pat, dp);
    }
}