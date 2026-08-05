class Pair {
    int first;
    int second;

    public Pair(int first , int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    private void bfs(int row , int col , int [][]visited , char [][]grid) {
        Queue<Pair> queue = new LinkedList<>();

        visited[row][col] = 1;
        queue.offer(new Pair(row , col));

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int ro = queue.peek().first;
            int co = queue.peek().second;
            queue.poll();

            for(int i = 0; i < 4; i++) {
                int nRow = ro + delRow[i];
                int nCol = co + delCol[i];

                if(nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    grid[nRow][nCol] == '1' &&
                    visited[nRow][nCol] == 0) {

                    visited[nRow][nCol] = 1;
                    queue.offer(new Pair(nRow , nCol));
                    
                }
            }
        }
    }


    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j] == 0  &&  grid[i][j] == '1') {
                    count++;
                    bfs(i , j , vis , grid);
                }
            }
        }

        return count;
    }
}