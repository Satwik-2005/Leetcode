class Solution {

    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int INF = (int) 1e8;

        int[] distance = new int[V];

        Arrays.fill(distance, INF);

        distance[src] = 0;

        // Relax all edges V - 1 times
        for(int i = 0; i < V - 1; i++) {

            boolean changed = false;

            for(int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(distance[u] != INF &&
                   distance[u] + wt < distance[v]) {

                    distance[v] = distance[u] + wt;
                    changed = true;
                }
            }

            // No change means shortest distances are finalized
            if(!changed)
                break;
        }

        // Check negative weight cycle
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(distance[u] != INF &&
               distance[u] + wt < distance[v]) {

                ArrayList<Integer> answer = new ArrayList<>();
                answer.add(-1);

                return answer;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int dist : distance)
            answer.add(dist);

        return answer;
    }
}