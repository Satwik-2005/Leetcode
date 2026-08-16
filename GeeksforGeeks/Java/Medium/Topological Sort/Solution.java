class Solution {
    
    private void build(int V, int[][] edges, List<List<Integer>> adj) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
    }
    
    private ArrayList<Integer> topoSort(List<List<Integer>> adj, int V) {
        int[] indegree = new int[V];
        
        for(int i=0;i<V;i++)
            for(int it : adj.get(i))
                indegree[it] += 1;
                
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<V;i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        
        ArrayList<Integer> topo = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            
            for(int it : adj.get(node)) {
                indegree[it] -= 1;
                
                if(indegree[it] == 0)
                    queue.offer(it);
            }
        }
        
        return topo;
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        build(V, edges, adj);
        
        return topoSort(adj, V);
    }
}