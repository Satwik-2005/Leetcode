class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n) {
        for(int i=0;i<=n;i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUltimateParent(int node) {
        if(node == parent.get(node))
            return node;
            
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node , ultimateParent);
        
        return parent.get(node);
    }
    
    void unionByRank(int u , int v) {
        int ultimateParent_U = findUltimateParent(u);
        int ultimateParent_V = findUltimateParent(v);
        
        if(ultimateParent_U  ==  ultimateParent_V)
            return;
            
        if(rank.get(ultimateParent_U) < rank.get(ultimateParent_V))
            parent.set(ultimateParent_U , ultimateParent_V);
            
        else if(rank.get(ultimateParent_V) < rank.get(ultimateParent_U))
            parent.set(ultimateParent_V , ultimateParent_U);
            
        else {
            parent.set(ultimateParent_V , ultimateParent_U);
            
            int rank_U = rank.get(ultimateParent_U);
            rank.set(ultimateParent_U , rank_U + 1);
        }
    }
    
    void unionBySize(int u , int v) {
        int ultimateParent_U = findUltimateParent(u);
        int ultimateParent_V = findUltimateParent(v);
        
        if(ultimateParent_U  ==  ultimateParent_V)
            return;
            
        if(size.get(ultimateParent_U) < size.get(ultimateParent_V)) {
            parent.set(ultimateParent_U , ultimateParent_V);
            size.set(ultimateParent_V , size.get(ultimateParent_V) + size.get(ultimateParent_U));
        }
            
        else {
            parent.set(ultimateParent_V , ultimateParent_U);
            size.set(ultimateParent_U , size.get(ultimateParent_U) + size.get(ultimateParent_V));
        }
    }
}


class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(isConnected[i][j] == 1)
                    ds.unionBySize(i , j);

        int count = 0;

        for(int i=0;i<n;i++)
            if(ds.parent.get(i) == i)
                count++;

        return count;
    }
}