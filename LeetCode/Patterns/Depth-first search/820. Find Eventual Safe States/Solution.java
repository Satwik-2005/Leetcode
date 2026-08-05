import java.util.*;

class Solution {

    static void adjacencyList(int[][] graph, int V, List<List<Integer>> adj, int[] inDegree) {
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int element : graph[i]) {
                adj.get(element).add(i); 
                inDegree[i]++;           
            }
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V];

        adjacencyList(graph, V, adj, inDegree);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for (int element : adj.get(node)) {
                inDegree[element]--;
                if (inDegree[element] == 0)
                    queue.offer(element);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}