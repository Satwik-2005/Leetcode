// class Solution {
//     public boolean isNegativeWeightCycle(int V, int[][] edges) {
//         // code here
        
//     }
// }


class Solution {

    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];

        for (int i = 0; i < V - 1; i++) {
            boolean updated = false;

            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            if (!updated) {
                break;
            }
        }

        for (int[] e : edges) {
            if (dist[e[0]] + e[2] < dist[e[1]]) {
                return true;
            }
        }

        return false;
    }
}
