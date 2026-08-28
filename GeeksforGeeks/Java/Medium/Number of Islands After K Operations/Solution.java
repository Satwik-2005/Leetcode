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
        return adjRow >= 0  &&   adjRow < n  &&  adjCol >= 0  &&  adjCol < m;
    } 
     
    public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Your code here
        DisjointSet dsu = new DisjointSet(n * m);
        
        int[][] visited = new int[n][m];
        int count = 0;
        int length = operators.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<length;i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            
            visited[row][col] = 1;
            count += 1;
            
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};
            
            for(int ind=0;ind<4;ind++) {
                int adjRow = row + delRow[ind];
                int adjCol = col + delCol[ind];
                
                if(isValid(adjRow, adjCol, n, m)) {
                    if(visited[adjRow][adjCol] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjRow * m + adjCol;
                        
                        if(dsu.findParent(nodeNo) != dsu.findParent(adjNodeNo)) {
                            count -= 1;
                            dsu.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            
            ans.add(count);
        }
        
        return ans;
    }
}