class Solution {
    
    private void build(List<List<Integer>> adj, int n, int[][] edges) {
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(v).add(u);
        }
    }
    
    private void findIndegree(List<List<Integer>> adj, int[] indegree) {
        int n = indegree.length;
        
        for(int i=0;i<n;i++) {
            for(int it : adj.get(i))
                indegree[it] += 1;
        }
    }
    
    private void queuePushing(Queue<Integer> queue, int[] indegree) {
        int n = indegree.length;
        
        for(int i=0;i<n;i++)
            if(indegree[i] == 0)
                queue.offer(i);
    }
    
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        build(adj, n, prerequisites);
        
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        findIndegree(adj, indegree);
        queuePushing(queue, indegree);
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            temp.add(node);
            
            for(int it : adj.get(node)) {
                indegree[it] -= 1;
                
                if(indegree[it] == 0)
                    queue.offer(it);
            }
        }
        
        return (temp.size() == n) ? temp : new ArrayList<>();
    }
}