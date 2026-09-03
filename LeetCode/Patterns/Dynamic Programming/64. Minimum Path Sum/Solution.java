class Solution {

    private int minimumPathSum(int row, int col, int[][] grid) {
        if(row == 0  &&  col == 0)
            return grid[row][col];

        if(row < 0  ||  col < 0)
            return Integer.MAX_VALUE;

        int up = minimumPathSum(row - 1 , col , grid);
        int left = minimumPathSum(row , col - 1 , grid);
        int min = Math.min(up , left);

        if(min == Integer.MAX_VALUE)
            return min;

        return grid[row][col] + min;
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return minimumPathSum(n - 1, m - 1, grid);
    }
}