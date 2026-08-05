class Trivial {
    int row;
    int col;
    int steps;

    public Trivial(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Trivial> queue = new LinkedList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new Trivial(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Trivial node = queue.poll();

            int row = node.row;
            int col = node.col;
            int steps = node.steps;

            dist[row][col] = steps;

            for(int i=0;i<4;i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(
                    newRow >= 0  &&  newRow < n  &&
                    newCol >= 0  &&  newCol < m  &&
                    visited[newRow][newCol] == false
                ) {
                    visited[newRow][newCol] = true;
                    queue.offer(new Trivial(newRow, newCol, steps + 1));
                }
            }
        }

        return dist;
    }
}