class Pair {
    int node;
    int distance;
    
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}


class Solution {
    
    private void build(int[][] edges, int V, List<List<Pair>> adj) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }
    }
    
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        
        this.build(edges, V, adj);
        
        int[] visited = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        pq.add(new Pair(0, 0));
        int sum = 0;
        
        while(!pq.isEmpty()) {
            Pair temp = pq.poll();
            
            int value = temp.node;
            int weight = temp.distance;
            
            if(visited[value] == 1)
                continue;
                
            visited[value] = 1;
            sum += weight;
            
            for(Pair iter : adj.get(value)) {
                int adjNode = iter.node;
                int edgeWeight = iter.distance;
                
                if(visited[adjNode] == 0)
                    pq.offer(new Pair(adjNode, edgeWeight));
            }
        }
        
        return sum;
    }
}

