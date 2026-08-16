class Solution {
    
    private boolean dfs(
        int node, 
        List<List<Integer>> adj, 
        int[] visited, int[] pathVisited, int[] check
    ) {
        visited[node] = 1;
        pathVisited[node] = 1;
        check[node] = 0;
        
        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                if(dfs(it, adj, visited, pathVisited, check) == true)
                    return true;
            }
            
            else if(pathVisited[it] == 1)
                return true;
        }
        
        pathVisited[node] = 0;
        check[node] = 1;
        return false;
    }
    
    private List<List<Integer>> build(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++) 
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        return adj;
    }
    
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = build(edges, V);
        
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        int[] check = new int[V];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<V;i++) 
            if(visited[i] == 0)
                dfs(i, adj, visited, pathVisited, check);
                
        for(int i=0;i<V;i++)
            if(check[i] == 1)
                list.add(i);
                
                
        return list;
    }
}