class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
    
    private int helper(int index, String s, int[] dp) {
        int n = s.length();
        
        if(index == n)
            return 1;
            
        if(s.charAt(index) == '0')
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        
        int ways = helper(index + 1, s, dp);
        
        if(index + 1 < n) {
            int twoDigit = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
            if(twoDigit >= 10 && twoDigit <= 26)
                ways += helper(index + 2, s, dp);
        }
        
        return dp[index] = ways;
    }
}