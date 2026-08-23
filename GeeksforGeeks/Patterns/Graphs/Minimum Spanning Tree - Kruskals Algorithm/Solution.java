class Pair {
    int node;
    int weight;
    
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;
    
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n) {
        for(int i=0;i<=n;i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    
    public void unionByRank(int u, int v) {
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);

        if(ultimateParentOfU == ultimateParentOfV)
            return;

        if(rank.get(ultimateParentOfU) < rank.get(ultimateParentOfV))
            parent.set(ultimateParentOfU, ultimateParentOfV);

        else if(rank.get(ultimateParentOfU) > rank.get(ultimateParentOfV))
            parent.set(ultimateParentOfV, ultimateParentOfU);

        else {
            parent.set(ultimateParentOfV, ultimateParentOfU);

            int rankU = rank.get(ultimateParentOfU);

            rank.set(ultimateParentOfU, rankU + 1);
        }
    }
    
    public void unionBySize(int u, int v) {
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);
        
        if(ultimateParentOfU == ultimateParentOfV)
            return;
            
        if(size.get(ultimateParentOfU) < size.get(ultimateParentOfV)) {
            parent.set(ultimateParentOfU, ultimateParentOfV);
            size.set(ultimateParentOfV, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
        }
        
        else {
            parent.set(ultimateParentOfV, ultimateParentOfU);
            size.set(ultimateParentOfU, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
        }
    }

    public int findParent(int node) {
        if(node == parent.get(node))
            return node;

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);

        return parent.get(node);
    }
}

class Solution {
    
    static void build(int[][] edges, int V, List<List<Pair>> adj) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
    }
    
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        
        build(edges, V, adj);
        
        List<Edge> list = new ArrayList<>();
        
        for(int i=0;i<V;i++) {
            for(int j=0;j<adj.get(i).size();j++) {
                int adjNode = adj.get(i).get(j).node;
                int edgeWeight = adj.get(i).get(j).weight;
                int node = i;
                
                Edge temp = new Edge(i, adjNode, edgeWeight);
                list.add(temp);
            }
        }
        
        Collections.sort(list);
        
        DisjointSet dsu = new DisjointSet(V);
        int mst = 0;
        
        for(int i=0;i<list.size();i++) {
            int weight = list.get(i).weight;
            int source = list.get(i).source;
            int destination = list.get(i).destination;
            
            if(dsu.findParent(source) != dsu.findParent(destination)) {
                mst += weight;
                dsu.unionBySize(source, destination);
            }
        }
        
        
        return mst;
    }
}
