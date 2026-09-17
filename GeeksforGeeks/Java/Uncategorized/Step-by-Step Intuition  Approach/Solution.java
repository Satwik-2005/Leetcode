class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // code here

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new int[]{v , 0});
            adj.get(v).add(new int[]{u , 1});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1],b[1]);
        });

        pq.offer(new int[]{src , 0});

        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            visited[node] = true;

            for(int[] neigh : adj.get(node)){
                int nei = neigh[0];
                int newCost = cost + neigh[1];
                if(!visited[nei] && newCost < dist[nei]){
                    dist[nei] = newCost;
                    pq.offer(new int[]{nei , newCost});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}