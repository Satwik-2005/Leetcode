class Solution {

    int minimumPathSum(int i , int j , int[][] grid) {
        if(i == 0  &&  j == 0)
            return grid[i][j];

        if(i < 0  ||  j < 0)
            return Integer.MAX_VALUE;

        int up = minimumPathSum(i - 1 , j , grid);
        int left = minimumPathSum(i , j - 1 , grid);
        int min = Math.min(up , left);

        if(min == Integer.MAX_VALUE)
            return min;

        return grid[i][j] + min;
    }

    int minimumPathSum(int i , int j , int[][] grid , int[][] dp) {
        if(i == 0  &&  j == 0)
            return grid[i][j];

        if(i < 0  ||  j < 0)
            return Integer.MAX_VALUE;

        if(dp[i][j] != -1)
            return dp[i][j];

        int up = minimumPathSum(i - 1 , j , grid , dp);
        int left = minimumPathSum(i , j - 1 , grid , dp);
        int min = Math.min(up , left);

        if(min == Integer.MAX_VALUE)
            return min;

        return dp[i][j] = grid[i][j] + min;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for(int i=0;i<m;i++) {
            int[] current = new int[n];

            for(int j=0;j<n;j++) {
                if(i == 0  &&  j == 0)
                    current[j] = grid[i][j];

                else {
                    int up = grid[i][j];

                    if(i > 0)
                        up += prev[j];
                    else
                        up += 1e9;

                    int left = grid[i][j];

                    if(j > 0)
                        left += current[j - 1];
                    else
                        left += 1e9;


                    current[j] = Math.min(left , up);
                }
            }

            prev = current;
        }

        return prev[n - 1];
    }
}