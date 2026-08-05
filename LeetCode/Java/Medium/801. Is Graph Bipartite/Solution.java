class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 = uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, color, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int col) {
        if (color[node] != -1) {
            // Already colored: check for conflict
            return color[node] == col;
        }
        color[node] = col;
        for (int nei : graph[node]) {
            // Try coloring neighbors with opposite color
            if (!dfs(graph, color, nei, 1 - col)) {
                return false;
            }
        }
        return true;
    }
}
