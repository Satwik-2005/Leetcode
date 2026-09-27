import java.util.*;

class Solution {

    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Result red = process('R', s, adj);
        Result blue = process('B', s, adj);

        int bestMix = 0;

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            if (s.charAt(u) == 'R' && s.charAt(v) == 'B') {
                bestMix = Math.max(bestMix, red.far[u] + blue.far[v] + 2);
            } else if (s.charAt(u) == 'B' && s.charAt(v) == 'R') {
                bestMix = Math.max(bestMix, red.far[v] + blue.far[u] + 2);
            }
        }

        return Math.max(Math.max(red.diameter, blue.diameter), bestMix);
    }

    static class Result {
        int[] far;
        int diameter;

        Result(int[] far, int diameter) {
            this.far = far;
            this.diameter = diameter;
        }
    }

    private Result process(char col, String s, List<List<Integer>> adj) {
        int n = s.length();
        int[] far = new int[n];
        boolean[] seen = new boolean[n];
        int diameterNodes = 0;

        for (int src = 0; src < n; src++) {
            if (seen[src] || s.charAt(src) != col) continue;

            List<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            seen[src] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                comp.add(u);

                for (int v : adj.get(u)) {
                    if (!seen[v] && s.charAt(v) == col) {
                        seen[v] = true;
                        q.add(v);
                    }
                }
            }

            int[] bfsStart = bfs(src, col, s, adj);
            int A = bfsStart[0];

            int[] bfsA = bfs(A, col, s, adj);
            int B = bfsA[0];
            Map<Integer, Integer> distA = getDistMap(A, col, s, adj);
            Map<Integer, Integer> distB = getDistMap(B, col, s, adj);

            int diameter = distA.getOrDefault(B, 0) + 1;
            diameterNodes = Math.max(diameterNodes, diameter);

            for (int node : comp) {
                int d1 = distA.getOrDefault(node, 0);
                int d2 = distB.getOrDefault(node, 0);
                far[node] = Math.max(d1, d2);
            }
        }

        return new Result(far, diameterNodes);
    }

    private int[] bfs(int start, char col, String s, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        int farNode = start;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (s.charAt(v) != col || dist.containsKey(v)) continue;

                dist.put(v, dist.get(u) + 1);
                q.add(v);

                if (dist.get(v) > dist.get(farNode)) {
                    farNode = v;
                }
            }
        }

        return new int[]{farNode};
    }

    private Map<Integer, Integer> getDistMap(int start, char col, String s, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (s.charAt(v) != col || dist.containsKey(v)) continue;

                dist.put(v, dist.get(u) + 1);
                q.add(v);
            }
        }

        return dist;
    }
}