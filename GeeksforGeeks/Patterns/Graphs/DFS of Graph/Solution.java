class Solution {
    
    private void dfs(
        int node, boolean[] visited, 
        ArrayList<Integer> list, 
        ArrayList<ArrayList<Integer>> adj
    ) {
        
        visited[node] = true;
        list.add(node);
        
        for(int it : adj.get(node)) {
            if(!visited[it])
                dfs(it, visited, list, adj);
        }
        
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        
        visited[0] = true;
        dfs(0, visited, list, adj);
        
        return list;
    }
}