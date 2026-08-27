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
    public int minConnect(int V, int[][] edges) {
        // code here
        DisjointSet dsu = new DisjointSet(V);
        
        int countExtra = 0;
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if(dsu.findParent(u) == dsu.findParent(v))
                countExtra += 1;
                
            else 
                dsu.unionBySize(u, v);
        }
        
        int countConnected = 0;
        
        for(int i=0;i<V;i++)
            if(dsu.findParent(i) == i)
                countConnected += 1;
                
        int ans = countConnected - 1;
        
        if(countExtra >= ans)
            return ans;
            
        return -1;
    }
}
