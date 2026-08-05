class Pair {
    int row;
    int col;
    
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    private void bfs(int row, int col, boolean[][] visited, char[][] grid, int n, int m) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        
        visited[row][col] = true;
        
        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            
            int row1 = node.row;
            int col1 = node.col;
            
            for(int delRow=-1;delRow<=1;delRow++) {
                for(int delCol=-1;delCol<=1;delCol++) {
                    int newRow = row1 + delRow;
                    int newCol = col1 + delCol;
                    
                    if(
                        newRow >= 0  &&  newCol >= 0  &&  newRow < n  &&  newCol < m &&
                        visited[newRow][newCol] == false  &&
                        grid[newRow][newCol] == 'L'
                    ) {
                        visited[newRow][newCol] = true;
                        queue.offer(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
    
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        
        for(int row=0;row<n;row++) {
            for(int col=0;col<m;col++) {
                if(visited[row][col] == false  &&  grid[row][col] == 'L') {
                    count += 1;
                    bfs(row, col, visited, grid, n, m);
                }
            }
        }
        
        return count;
    }
}