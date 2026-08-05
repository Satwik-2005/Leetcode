class Trible {
    int first;
    int second;
    int distance;

    public Trible(int first , int second , int distance) {
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][]visited = new int[n][m];
        int [][]distance = new int[n][m];
        Queue<Trible> queue = new LinkedList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new Trible(i , j , 0));
                    visited[i][j] = 1;
                }
                else 
                    visited[i][j] = 0;
            }
        }


        int []delRow = {-1 , 0 , 1 , 0};
        int []delCol = {0 , 1 , 0 , -1};

        while(!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().distance;

            queue.poll();
            distance[row][col] = steps;

            for(int i=0;i<4;i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow >= 0  &&  nRow < n  &&  nCol >= 0  &&  nCol < m  &&  visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    queue.offer(new Trible(nRow , nCol , steps+1));
                }
            }
        }

        return distance;
    }
}