class Solution {

    static void adjacencyList(List<List<Integer>> adj , int [][]prerequisites , int numCourses) {
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        adjacencyList(adj , prerequisites , numCourses);

        int []inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++)
            for(int iter : adj.get(i))
                inDegree[iter]++;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
            if(inDegree[i] == 0)
                queue.offer(i);

        int []topo = new int[numCourses];
        int i = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo[i++] = node;

            for(int iter : adj.get(node)) {
                inDegree[iter]--;
                
                if(inDegree[iter] == 0)
                    queue.offer(iter);
            }
        }

        return (i == numCourses) ? topo : new int[]{};
    }
}