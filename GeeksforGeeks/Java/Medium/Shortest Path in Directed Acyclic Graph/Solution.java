class Pair {
    int node;
    int distance;
    
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    
    private void build(int[][] edges, ArrayList<ArrayList<Pair>> adj) {
        int n = edges.length;
        
        for(int i=0;i<n;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int dist = edges[i][2];
            
            adj.get(u).add(new Pair(v, dist));
        }
    }
    
    private void topoSort(
        int node,
        int[] visited, Stack<Integer> stack,
        ArrayList<ArrayList<Pair>> adj
    ) {
        visited[node] = 1;
        
        for(Pair it : adj.get(node))
            if(visited[it.node] == 0)
                topoSort(it.node, visited, stack, adj);
                
        stack.push(node);
    }
    
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        
        build(edges, adj);
        
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++) 
            if(visited[i] == 0)
                topoSort(i, visited, stack, adj);
                
        
        ArrayList<Integer> distance = new ArrayList<>(Collections.nCopies(V, (int) (1e9)));
        
        distance.set(0, 0);
        
        while(!stack.isEmpty()) {
            int node = stack.pop();
            
            if (distance.get(node) != 1e9) {
                for(int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).node;
                    int wt = adj.get(node).get(i).distance;

                    if(distance.get(node) + wt < distance.get(v)) {
                        distance.set(v, wt + distance.get(node));
                    }
                }
            }
        }
        
        for (int i = 0; i < V; i++) {
            if (distance.get(i) == 1e9) {
                distance.set(i, -1);
            }
        }
        
        return distance;
    }
}