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

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return minimumPathSum(m - 1 , n - 1 , grid);
    }
}