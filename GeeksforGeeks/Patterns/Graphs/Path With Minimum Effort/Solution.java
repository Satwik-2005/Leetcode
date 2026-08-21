class Trible {
    int distance;
    int row;
    int col;
    
    public Trible(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}


class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        PriorityQueue<Trible> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[][] distance = new int[n][m];
        
        for(int[] dis : distance)
            Arrays.fill(dis, (int) (1e9));
            
        distance[0][0] = 0;
        pq.offer(new Trible(0, 0, 0));
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        while(!pq.isEmpty()) {
            Trible node = pq.poll();
            
            int dist = node.distance;
            int row = node.row;
            int col = node.col;
            
            for(int i=0;i<4;i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                
                if(
                    newRow >= 0  &&  newRow < n  &&
                    newCol >= 0  &&  newCol < m  
                ) {
                    int newEffort = Math.max(Math.abs(mat[newRow][newCol] - mat[row][col]), dist);
                    
                    if(newEffort < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newEffort;
                        pq.offer(new Trible(newEffort, newRow, newCol));
                    }
                }
            }
        }
        
        return distance[n - 1][m - 1];
    }
}
