// class Trible {
//     int distance;
//     int row;
//     int col;
    
//     public Trible(int distance, int row, int col) {
//         this.distance = distance;
//         this.row = row;
//         this.col = col;
//     }
// }

// class Solution {
//     public int shortestPath(int[][] mat, int[] src, int[] dest) {
//         // code here
//         if(src[0] == dest[0]  &&  src[1] == dest[1])
//             return 0;
            
//         int n = mat.length;
//         int m = mat[0].length;
            
//         Queue<Trible> queue = new LinkedList<>();
//         int[][] distance = new int[n][m];
        
//         int[] delRow = {-1, 0, 1, 0};
//         int[] delCol = {0, 1, 0, -1};
        
//         for(int[] dist : distance)
//             Arrays.fill(dist, (int) (1e9));
            
//         distance[src[0]][src[1]] = 0;
//         queue.offer(new Trible(0, src[0], src[1]));
        
//         while(!queue.isEmpty()) {
//             Trible node = queue.poll();
            
//             int dist = node.distance;
//             int row = node.row;
//             int col = node.col;
            
//             for(int i=0;i<4;i++) {
//                 int newRow = row + delRow[i];
//                 int newCol = col + delCol[i];
                
//                 if(
//                     newRow >= 0  &&  newCol >= 0  &&
//                     newRow < n  &&  newCol < m  &&
//                     mat[newRow][newCol] == 1  &&
//                     1 + dist < distance[newRow][newCol]
//                 ) {
//                     distance[newRow][newCol] = 1 + dist;
                    
//                     if(newRow == dest[0]  &&  newCol == dest[1])
//                         return dist + 1;
                        
//                     queue.offer(new Trible(dist + 1, newRow, newCol));
//                 }
//             }
//         }
        
//         return -1;
//     }
// }



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

    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        
        if(mat[src[0]][src[1]] == 0 || mat[dest[0]][dest[1]] == 0)
            return -1;

        if(src[0] == dest[0] && src[1] == dest[1])
            return 0;

        int n = mat.length;
        int m = mat[0].length;

        Queue<Trible> queue = new LinkedList<>();

        int[][] distance = new int[n][m];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int[] dist : distance)
            Arrays.fill(dist, (int) 1e9);

        distance[src[0]][src[1]] = 0;

        queue.offer(
            new Trible(0, src[0], src[1])
        );

        while(!queue.isEmpty()) {

            Trible node = queue.poll();

            int dist = node.distance;
            int row = node.row;
            int col = node.col;

            for(int i = 0; i < 4; i++) {

                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(
                    newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    mat[newRow][newCol] == 1 &&
                    dist + 1 < distance[newRow][newCol]
                ) {

                    distance[newRow][newCol] = dist + 1;

                    if(newRow == dest[0] && newCol == dest[1])
                        return dist + 1;

                    queue.offer(
                        new Trible(
                            dist + 1,
                            newRow,
                            newCol
                        )
                    );
                }
            }
        }

        return -1;
    }
}