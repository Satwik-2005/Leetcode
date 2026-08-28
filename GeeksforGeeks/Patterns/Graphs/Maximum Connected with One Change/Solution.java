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
    
    private boolean isValid(int adjRow, int adjCol, int n, int m) {
        return adjRow >= 0  &&  adjRow < n  &&  adjCol >= 0  &&  adjCol < m;
    }
    
    public int maxConnection(int grid[][]) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        
        DisjointSet dsu = new DisjointSet(n * m);
        
        for(int row=0;row<n;row++) {
            for(int col=0;col<m;col++) {
                if(grid[row][col] == 0)
                    continue;
                    
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                
                for(int ind=0;ind<4;ind++) {
                    int newRow = row + dr[ind];
                    int newCol = col + dc[ind];
                    
                    if(isValid(newRow, newCol, n, m)  &&  grid[newRow][newCol] == 1) {
                        int newNode = row * n + col;
                        int adjNode = newRow * n + newCol;
                        
                        dsu.unionBySize(newNode, adjNode);
                    }
                }
            }
        }
        
        int max = 0;
        
        for(int row=0;row<n;row++) {
            for(int col=0;col<m;col++) {
                if(grid[row][col] == 1)
                    continue;
                    
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                
                Set<Integer> set = new HashSet<>();
                
                for(int i=0;i<4;i++) {
                    int newRow = row + dr[i];
                    int newCol = col + dc[i];
                    
                    if(isValid(newRow, newCol, n, m)) 
                        if(grid[newRow][newCol] == 1)
                            set.add(dsu.findParent(newRow * n + newCol));
                }
                
                int sizeTotal = 0;
                
                for(Integer parents : set)
                    sizeTotal += dsu.size.get(parents);
                    
                max = Math.max(max, sizeTotal + 1);
            }
        }
        
        for(int cellNo = 0;cellNo < n * m;cellNo ++)
            max = Math.max(max, dsu.size.get(dsu.findParent(cellNo)));
            
            
        return max;
    }
}