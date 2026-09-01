class Solution {
    
     private int maxPoints(int day, int last, int[][] mat, int[][] dp) {
        if(day == 0) {
            int maximum = 0;
            
            for(int i=0;i<=2;i++)
                if(i != last)
                    maximum = Math.max(maximum, mat[0][i]);
                    
            return maximum;
        }
        
        if(dp[day][last] != -1)
            return dp[day][last];
        
        int maximum = 0;
        
        for(int i=0;i<=2;i++) {
            if(i != last) {
                int points = mat[day][i] + maxPoints(day - 1, i, mat, dp);
                maximum = Math.max(maximum, points);
            }
        }
        
        return dp[day][last] = maximum;
    }
    
    private int maxPoints(int day, int last, int[][] mat) {
        if(day == 0) {
            int maximum = 0;
            
            for(int i=0;i<=2;i++)
                if(i != last)
                    maximum = Math.max(maximum, mat[0][i]);
                    
            return maximum;
        }
        
        int maximum = 0;
        
        for(int i=0;i<=2;i++) {
            if(i != last) {
                int points = mat[day][i] + maxPoints(day - 1, i, mat);
                maximum = Math.max(maximum, points);
            }
        }
        
        return maximum;
    }
    
    public int maximumPoints(int mat[][]) {
        // code here
        int n = mat.length;
        int[][] dp = new int[n][4];
        
        for(int[] array : dp)
            Arrays.fill(array, -1);
        
        return maxPoints(n - 1, 3, mat, dp);
    }
}