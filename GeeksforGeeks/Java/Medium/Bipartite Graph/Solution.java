import java.util.*;

 class Solution {

     private boolean dfs(
         int node,
         int colour,
         int[] color,
         List<List<Integer>> adj
     ) {

         color[node] = colour;

         for(int adjacent : adj.get(node)) {

             // Not colored yet
             if(color[adjacent] == -1) {

                 if(!dfs(adjacent, 1 - colour, color, adj))
                     return false;
             }

             // Adjacent nodes have same color
             else if(color[adjacent] == color[node]) {
                 return false;
             }
         }

         return true;
     }

     public boolean isBipartite(int V, int[][] edges) {

         // Create adjacency list
         List<List<Integer>> adj = new ArrayList<>();

         for(int i = 0; i < V; i++)
             adj.add(new ArrayList<>());

         // Convert edge list to adjacency list
         for(int[] edge : edges) {

             int u = edge[0];
             int v = edge[1];

             adj.get(u).add(v);
             adj.get(v).add(u);
         }

         // -1 = not colored
         //  0 = color 0
         //  1 = color 1
         int[] color = new int[V];

         Arrays.fill(color, -1);

         // Graph can have multiple components
         for(int i = 0; i < V; i++) {

             if(color[i] == -1) {

                 if(!dfs(i, 0, color, adj))
                     return false;
             }
         }

         return true;
     }
 }