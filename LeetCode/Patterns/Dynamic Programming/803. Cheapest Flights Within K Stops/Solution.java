class Pair {
    int first;
    int second;

    public Pair(int first , int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int distance;
    int node;
    int stops;

    public Tuple(int distance , int node , int stops) {
        this.distance = distance;
        this.node = node;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        int m = flights.length;

        for(int i=0;i<m;i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            adj.get(u).add(new Pair(v , w));
        }

        Queue<Tuple> queue = new LinkedList<>();
        int[] distance = new int[n];

        for(int i=0;i<n;i++)
            distance[i] = (int)1e9;

        distance[src] = 0;
        queue.offer(new Tuple(0 , src , 0));

        while(!queue.isEmpty()) {
            Tuple temp = queue.poll();

            int stops = temp.distance;
            int node = temp.node;
            int cost = temp.stops;

            if(stops > k)
                continue;

            for(Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edN = iter.second;

                if(cost + edN  <  distance[adjNode]  &&  stops <= k) {
                    distance[adjNode] = cost + edN;

                    queue.offer(new Tuple(stops + 1 , adjNode , cost + edN));
                }
            }
        }

        if(distance[dst] == (int)1e9)
            return -1;

        return distance[dst];
    }
}