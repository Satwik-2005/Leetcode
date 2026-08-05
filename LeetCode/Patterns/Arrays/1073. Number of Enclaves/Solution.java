class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for(int row=0;row<n;row++) {
            for(int col=0;col<m;col++) {
                if(row == 0  ||  row == n - 1  ||  col == 0  ||  col == m - 1) {
                    if(grid[row][col] == 1) {
                        visited[row][col] = 1;
                        queue.offer(new Pair(row, col));
                    }
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Pair node = queue.poll();

            int row = node.row;
            int col = node.col;

            for(int i=0;i<4;i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(
                    newRow >= 0  && newCol >= 0  &&
                    newRow < n  &&  newCol < m  &&
                    visited[newRow][newCol] == 0  &&
                    grid[newRow][newCol] == 1
                ) {
                    visited[newRow][newCol] = 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }

        int cnt = 0;

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j] == 1  && visited[i][j] == 0)
                    cnt += 1;


        return cnt;
    }
}