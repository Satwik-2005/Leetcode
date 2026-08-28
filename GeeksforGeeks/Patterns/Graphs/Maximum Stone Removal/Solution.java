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
    public int maxRemove(int[][] stones) {
        // Code here
        int n = stones.length;
        
        int maxRow = 0;
        int maxCol = 0;
        
        for(int i=0;i<n;i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        DisjointSet dsu = new DisjointSet(maxRow + maxCol + 1);
        
        for(int i=0;i<n;i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            
            dsu.unionBySize(nodeRow, nodeCol);
            
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        
        int count = 0;
        
        for(Map.Entry<Integer, Integer> it : map.entrySet())
            if(dsu.findParent(it.getKey()) == it.getKey())
                count += 1;
                
        return n - count;
    }
};
