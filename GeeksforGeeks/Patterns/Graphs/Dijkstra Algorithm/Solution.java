import java.util.*;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {

    private void build(List<List<Pair>> adj, int[][] edges, int V) {

        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Undirected graph
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
    }

    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {

        List<List<Pair>> adj = new ArrayList<>();

        build(adj, edges, V);

        int[] distance = new int[V];

        Arrays.fill(distance, (int) 1e9);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.distance - b.distance);

        distance[src] = 0;

        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int dis = current.distance;

            // Ignore outdated entry
            if(dis > distance[node])
                continue;

            for(Pair edge : adj.get(node)) {

                int adjacent = edge.node;
                int edgeWeight = edge.distance;

                if(dis + edgeWeight < distance[adjacent]) {

                    distance[adjacent] = dis + edgeWeight;

                    pq.offer(
                        new Pair(adjacent, distance[adjacent])
                    );
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int d : distance)
            answer.add(d);

        return answer;
    }
}