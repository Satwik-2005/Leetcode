class Solution {
    
    private int distance(int index1, int index2, String s, String t, int[][] dp) {
        if(index1 < 0) 
            return index2 + 1;
        
        if(index2 < 0) 
            return index1 + 1;
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(s.charAt(index1) == t.charAt(index2))
            return dp[index1][index2] = distance(index1 - 1, index2 - 1, s, t, dp);
            
        return dp[index1][index2] = 1 +  Math.min(
            distance(index1, index2 - 1, s, t, dp),
            Math.min(
                distance(index1 - 1, index2, s, t, dp),
                distance(index1 - 1, index2 - 1, s, t, dp)
            )
        );
    }
    
    private int distance(int index1, int index2, String s, String t) {
        if(index1 < 0) return index2 + 1;
        if(index2 < 0) return index1 + 1;
        
        if(s.charAt(index1) == t.charAt(index2))
            return distance(index1 - 1, index2 - 1, s, t);
            
        return 1 +  Math.min(
            distance(index1, index2 - 1, s, t),
            Math.min(
                distance(index1 - 1, index2, s, t),
                distance(index1 - 1, index2 - 1, s, t)
            )
        );
    }
    
    public int editDistance(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return distance(n - 1, m - 1, s1, s2, dp);
    }
}