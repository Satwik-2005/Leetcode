// class DisjointSet {
//     List<Integer> rank = new ArrayList<>();
//     List<Integer> parent = new ArrayList<>();
    
//     public DisjointSet(int n) {
//         for(int i=0;i<=n;i++) {
//             rank.add(0);
//             parent.add(i);
//         }
//     }
    
//     public void unionByRank(int u, int v) {
//         int ultimateParentOfU = findParent(u);
//         int ultimateParentOfV = findParent(v);
        
//         if(ultimateParentOfU == ultimateParentOfV)
//             return;
            
//         if(rank.get(ultimateParentOfU) < rank.get(UltimateParentOfV))
//             parent.set(ultimateParentOfU, UltimateParentOfV);
            
//         else if(rank.get(ultimateParentOfU) > rank.get(UltimateParentOfV))
//             parent.set(UltimateParentOfV, ultimateParentOfU);
            
//         else {
//             parent.set(UltimateParentOfV, ultimateParentOfU);
            
//             int rankU = rank.get(ultimateParentOfU);
            
//             rank.set(ultimateParentOfU, rankU + 1);
//         }
//     }
    
//     public int findParent(int node) {
//         if(node == parent.get(node))
//             return node;
            
//         int ultimateParent = findParent(parent.get(node));
//         parent.set(node, ultimateParent);
        
//         return parent.get(node);
//     }
// }

// class Solution {
//     public ArrayList<Integer> DSU(int n, int[][] queries) {
//         // code here
        
//         DisjointSet dsu = new DisjointSet(n);
        
        
//     }
// }
import java.util.*;

class DisjointSet {

    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {

        for(int i = 0; i <= n; i++)
            parent.add(i);
    }

    public int findParent(int node) {

        if(node == parent.get(node))
            return node;

        int ultimateParent = findParent(parent.get(node));

        parent.set(node, ultimateParent);

        return ultimateParent;
    }

    public void union(int x, int z) {

        int parentX = findParent(x);
        int parentZ = findParent(z);

        if(parentX == parentZ)
            return;

        // Representative of z's group remains the representative
        parent.set(parentX, parentZ);
    }
}

class Solution {

    public ArrayList<Integer> DSU(int n, int[][] queries) {

        DisjointSet dsu = new DisjointSet(n);

        ArrayList<Integer> answer = new ArrayList<>();

        for(int[] query : queries) {

            if(query[0] == 1) {

                int x = query[1];
                int z = query[2];

                dsu.union(x, z);
            }

            else {

                int x = query[1];

                answer.add(dsu.findParent(x));
            }
        }

        return answer;
    }
}