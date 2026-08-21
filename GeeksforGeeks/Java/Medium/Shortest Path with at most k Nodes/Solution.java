class Pair {
    int col;
    int weight;
    
    public Pair(int col, int weight) {
        this.col = col;
        this.weight = weight;
    }
}

class Trible {
    int stops;
    int node;
    int distance;
    
    public Trible(int stops, int node, int distance) {
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    
    private static void build(List<List<Pair>> adj, int V, int[][] edges) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int distance = edge[2];
            
            adj.get(u).add(new Pair(v, distance));
        }
    }
    
    public static int findCheapestCost(int n, int[][] edges, int src, int dst, int k) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        
        build(adj, n, edges);
        
        Queue<Trible> queue = new LinkedList<>();
        int[] distance = new int[n];
        
        Arrays.fill(distance, (int) (1e9));
        
        distance[src] = 0;
        queue.offer(new Trible(0, src, 0));
        
        while(!queue.isEmpty()) {
            Trible temp = queue.poll();
            
            int stops = temp.stops;
            int val = temp.node;
            int dist = temp.distance;
            
            if(stops > k) 
                continue;
                
            for(Pair iter : adj.get(val)) {
                int adjNode = iter.col;
                int edgeNode = iter.weight;
                
                if(dist + edgeNode < distance[adjNode]  &&  stops <= k) {
                    distance[adjNode] = dist + edgeNode;
                    queue.offer(new Trible(stops + 1, adjNode, dist + edgeNode));
                }
            }
        }
        
        if(distance[dst] == (int) (1e9))
            return -1;
            
        return distance[dst];
    }
}