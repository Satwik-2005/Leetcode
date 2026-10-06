class Solution {

    int[][] dp;

    private int dfs(int row, int col, int[][] matrix, int n, int m) {

        if (dp[row][col] != 0)
            return dp[row][col];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int maxLength = 1;

        for (int i = 0; i < 4; i++) {

            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < m &&
                matrix[newRow][newCol] > matrix[row][col]) {

                maxLength = Math.max(
                    maxLength,
                    1 + dfs(newRow, newCol, matrix, n, m)
                );
            }
        }

        return dp[row][col] = maxLength;
    }

    public int longIncPath(int[][] matrix, int n, int m) {

        dp = new int[n][m];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                answer = Math.max(
                    answer,
                    dfs(i, j, matrix, n, m)
                );
            }
        }

        return answer;
    }
}