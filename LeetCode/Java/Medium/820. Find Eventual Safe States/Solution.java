class Solution {

    private void build(List<List<Integer>> adj, int[][] edges, int V) {
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int u = 0; u < V; u++) {
            for(int v : edges[u]) {
                adj.get(v).add(u);
            }
        }
    }

    private void findIndegree(int V, int[] indegree, List<List<Integer>> adj) {
        for(int i=0;i<V;i++) {
            for(int it : adj.get(i))
                indegree[it] += 1;
        }
    }

    private void queueAdding(int[] indegree, Queue<Integer> queue) {
        int V = indegree.length;

        for(int i=0;i<V;i++)
            if(indegree[i] == 0)
                queue.offer(i);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        build(adj, graph, V);

        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        findIndegree(V, indegree, adj);
        queueAdding(indegree, queue);

        List<Integer> topo = new ArrayList<>();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for(int it : adj.get(node)) {
                indegree[it] -= 1;

                if(indegree[it] == 0)
                    queue.offer(it);
            }
        }

        Collections.sort(topo);

        return topo;
    }
}