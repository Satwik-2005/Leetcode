class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] dp = new int[n][n];     // best score to reach this cell from 'S'
        int[][] cnt = new int[n][n];    // number of ways to get that best score

        for(int[] row : dp)
            Arrays.fill(row, -1);       // -1 = unreachable

        dp[n - 1][n - 1] = 0;           // 'S' is the start
        cnt[n - 1][n - 1] = 1;

        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == n - 1  &&  j == n - 1)
                    continue;

                char c = board.get(i).charAt(j);
                if(c == 'X')
                    continue;

                int best = -1;
                long ways = 0;

                for(int[] d : dirs) {
                    int pi = i + d[0];
                    int pj = j + d[1];

                    if(pi >= n  ||  pj >= n  ||  dp[pi][pj] == -1)
                        continue;

                    if(dp[pi][pj] > best) {
                        best = dp[pi][pj];
                        ways = cnt[pi][pj];
                    }
                    else if(dp[pi][pj] == best) {
                        ways += cnt[pi][pj];
                    }
                }

                if(best == -1)
                    continue;

                dp[i][j] = best + (c == 'E' ? 0 : c - '0');   // 'E' is worth 0
                cnt[i][j] = (int) (ways % MOD);
            }
        }

        if(dp[0][0] == -1)
            return new int[]{0, 0};

        return new int[]{dp[0][0], cnt[0][0]};
    }
}