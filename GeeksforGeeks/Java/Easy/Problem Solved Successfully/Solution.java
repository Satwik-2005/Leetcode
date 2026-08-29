class Solution {
    private int timer = 0;

    public void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> bridges, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;

        for (Integer neighbor : adj.get(node)) {

            if (neighbor == parent) {
                continue;
            }

            if (!vis[neighbor]) {

                dfs(neighbor, node, vis, tin, low, bridges, adj);

                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > tin[node]) {
                    if (node < neighbor) {
                        bridges.add(new ArrayList<>(Arrays.asList(node, neighbor)));
                    } else {
                        bridges.add(new ArrayList<>(Arrays.asList(neighbor, node)));
                    }
                }

            } else {

                low[node] = Math.min(low[node], low[neighbor]);

            }

        }
    }

    public ArrayList<ArrayList<Integer>> criticalConnections(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];

        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, tin, low, bridges, adj);

        Collections.sort(bridges, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> v1, ArrayList<Integer> v2) {
                if (v1.get(0) < v2.get(0)) {
                    return -1;
                } else if (v1.get(0) > v2.get(0)) {
                    return 1;
                } else {
                    if (v1.get(1) <= v2.get(1)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        return bridges;
    }
}