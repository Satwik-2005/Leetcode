import java.util.*;

class Solution {

    public String findOrder(String[] words) {
        int n = words.length;

        // Step 1: Collect unique characters
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }

        int K = set.size();

        // Step 2: Map characters to indices
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (char ch : set) {
            map.put(ch, idx++);
        }

        // Step 3: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 4: Build graph
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // Prefix invalid case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    adj.get(map.get(c1)).add(map.get(c2));
                    break;
                }
            }
        }

        // Step 5: Topological Sort (Kahn's Algo)
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) q.offer(v);
            }
        }

        if (topo.size() < K) return "";

        // Step 6: Reverse map to build answer
        char[] rev = new char[K];
        for (char ch : map.keySet()) {
            rev[map.get(ch)] = ch;
        }

        StringBuilder ans = new StringBuilder();
        for (int node : topo) {
            ans.append(rev[node]);
        }

        return ans.toString();
    }
}