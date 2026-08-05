class Solution {

    private void dfs(int node, boolean[] visited, int[][] isConnected) {

        visited[node] = true;

        for(int j = 0; j < isConnected.length; j++) {

            if(isConnected[node][j] == 1 && !visited[j]) {
                dfs(j, visited, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;

        boolean[] visited = new boolean[V];

        int count = 0;

        for(int i = 0; i < V; i++) {

            if(!visited[i]) {
                count++;
                dfs(i, visited, isConnected);
            }
        }

        return count;
    }
}