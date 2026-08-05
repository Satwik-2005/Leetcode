class Pair {
    int child;
    int parent;
    
    public Pair(int child, int parent) {
        this.child = child;
        this.parent = parent;
    }
}

class Solution {
    
    private boolean bfs(int node, int[] visited, List<List<Integer>> adj, int V) {
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(node, -1));
        visited[node] = 1;
        
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int child = temp.child;
            int parent = temp.parent;
            
            for(int adjacent : adj.get(child)) {
                if(visited[adjacent] != 1) {
                    queue.offer(new Pair(adjacent, child));
                    visited[adjacent] = 1;
                }
                
                else if(parent != adjacent)
                    return true;
            }
        }
        
        return false;
    }
    
    private List<List<Integer>> convert(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = convert(edges, V);
        int[] visited = new int[V];
        
        for(int i=0;i<V;i++) 
            if(visited[i] != 1)
                if(bfs(i, visited, adj, V))
                    return true;
                    
        return false;
    }
}