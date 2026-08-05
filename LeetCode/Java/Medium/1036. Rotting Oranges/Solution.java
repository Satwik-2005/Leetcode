class Trivial {
    int row;
    int col;
    int time;

    public Trivial(int row , int col , int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Trivial> queue = new LinkedList<>();
        int [][]visited = new int[n][m];
        int countFresh = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Trivial(i , j , 0));
                    visited[i][j] = 2;
                }
                
                if(grid[i][j] == 1)
                    countFresh += 1;
            }
        }

        int []delRow = {-1 , 0 , 1 , 0};
        int []delCol = {0 , 1 , 0 , -1};
        int count = 0;
        int tm = 0;

        while(!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;

            tm = Math.max(tm , time);

            queue.poll();

            for(int i=0;i<4;i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow >= 0  &&  nRow < n  &&  nCol >= 0  &&  nCol < m 
                    &&  visited[nRow][nCol] == 0  &&  grid[nRow][nCol] == 1) {
                        queue.offer(new Trivial(nRow , nCol , tm + 1));
                        visited[nRow][nCol] = 2;
                        count++;
                    }
            }
        }

        if(count != countFresh) 
            return -1;

        return tm;
    }
}