class Solution {
    
    private boolean dfs(
        int node,
        List<List<Integer>> adj, 
        int[] visited, int[] pathVisited
    ) {
        visited[node] = 1;
        pathVisited[node] = 1;
        
        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                if(dfs(it, adj, visited, pathVisited) == true)
                    return true;
            }
                    
            else if(pathVisited[it] == 1)
                return true;
        }
        
        pathVisited[node] = 0;
        return false;
    }
    
    private void build(List<List<Integer>> adj, int[][] edges, int V) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        
        build(adj, edges, V);
        
        for(int i=0;i<V;i++) 
            if(visited[i] == 0)
                if(dfs(i, adj, visited, pathVisited) == true)
                    return true;
                    
        return false;
    }
}