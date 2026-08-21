class Pair {
    int distance;
    int node;
    
    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    
    private void build(int[][] edges, int V, List<List<Pair>> adj) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }
    }
    
    public int countPaths(int V, int[][] edges) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        
        build(edges, V, adj);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] distance = new int[V];
        int[] weight = new int[V];
        
        final int mod = (int) (1e9 + 7);
        
        Arrays.fill(distance, (int) (1e9));
        Arrays.fill(weight, 0);
        
        distance[0] = 0;
        weight[0] = 1;
        pq.offer(new Pair(0, 0));
        
        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            
            int dist = node.distance;
            int value = node.node;
            
            for(Pair iter : adj.get(value)) {
                int edgeWeight = iter.distance;
                int adjNode = iter.node;
                
                if(dist + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dist + edgeWeight;
                    
                    pq.offer(new Pair(dist + edgeWeight, adjNode));
                    
                    weight[adjNode] = weight[value];
                }
                
                else if(dist + edgeWeight  ==  distance[adjNode]) 
                    weight[adjNode] = (weight[adjNode] + weight[value]) % mod;
            }
        }
        
        return weight[V - 1] % mod;
    }
}
