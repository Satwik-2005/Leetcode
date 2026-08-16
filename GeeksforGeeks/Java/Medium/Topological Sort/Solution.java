class Solution {
    
    private void dfs(
        int node,
        List<List<Integer>> adj, 
        int[] visited,
        Stack<Integer> stack
    ) {
        visited[node] = 1;
        
        for(int it : adj.get(node)) {
            if(visited[it] == 0)
                dfs(it, adj, visited, stack);
        }
        
        stack.push(node);
    }
    
    private void build(List<List<Integer>> adj, int V, int[][] edges) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        build(adj, V, edges);
        
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        
        for(int i=0;i<V;i++)
            if(visited[i] == 0)
                dfs(i, adj, visited, stack);
                
        ArrayList<Integer> list = new ArrayList<>(stack);
        Collections.reverse(list); 
        
        return list;
    }
}