class Solution {
    
    private void dfs(
        int node, int[] visited,
        List<List<Integer>> adj
    ) {
        visited[node] = 1;
        
        for(int it : adj.get(node))
            if(visited[it] == 0)
                dfs(it, visited, adj);
    }
    
    private void build(int V, int[][] edges, List<List<Integer>> adj) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
    }
    
    private void dfs(
        int node, int[] visited,
        List<List<Integer>> adj, 
        Stack<Integer> stack
    ) {
        visited[node] = 1;
        
        for(int it : adj.get(node))
            if(visited[it] == 0)
                dfs(it, visited, adj, stack);
                
        stack.push(node);
    }
    
    private void reverse(
        int V, int[] visited,
        List<List<Integer>> adj,
        List<List<Integer>> adjReverse
    ) {
        for(int i=0;i<V;i++)
            adjReverse.add(new ArrayList<>());
            
        for(int i=0;i<V;i++) {
            visited[i] = 0;
            
            for(int it : adj.get(i))
                adjReverse.get(it).add(i);
        }
    }
    
    public int kosaraju(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        build(V, edges, adj);
        
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++)
            if(visited[i] == 0)
                dfs(i, visited, adj, stack);
                
        List<List<Integer>> adjReverse = new ArrayList<>();
        
        reverse(V, visited, adj, adjReverse);
        
        int scc = 0;
        
        while(!stack.isEmpty()) {
            int node = stack.pop();
            
            if(visited[node] == 0) {
                scc += 1;
                dfs(node, visited, adjReverse);
            }
        }
        
        return scc;
    }
}