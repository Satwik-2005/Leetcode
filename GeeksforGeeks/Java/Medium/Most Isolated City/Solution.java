class Solution {
    
    private void makeDistanceArray(int n, int[][] edges, int[][] distance) {
        for(int i=0;i<n;i++) 
            for(int j=0;j<n;j++)
                distance[i][j] = (int) (1e9);
                
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            distance[u][v] = wt;
            distance[v][u] = wt;
        }
    }
    
    private void floyydWarshell(int[][] edges, int[][] distance, int n) {
        for(int i=0;i<n;i++)
            distance[i][i] = 0;
        
        for(int k=0;k<n;k++) 
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++) 
                    if(distance[i][k] != (int) (1e9)  &&  distance[k][j] != (int) (1e9))
                        distance[i][j] = Math.min(
                                                distance[i][j] , 
                                                distance[i][k] + distance[k][j]
                                            );
    }
    
    public int findCity(int n, int[][] edges, int dis) {
        // code here
        int[][] distance = new int[n][n];
        
        makeDistanceArray(n, edges, distance);
        floyydWarshell(edges, distance, n);
        
        int countCity = n;
        int city = -1;
        
        for(int i=0;i<n;i++) {
            int count = 0;
            
            for(int j=0;j<n;j++) 
                if(distance[i][j] <= dis)
                    count += 1;
                    
            if(count <= countCity) {
                countCity = count;
                city = i;
            }
        }
        
        return city;
    }
}