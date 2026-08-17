class Solution {
    
    private void build(int[][] edges, int n, List<List<Integer>> adj) {
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
    }
    
    private void findIndegree(List<List<Integer>> adj, int[] indegree) {
        int n = indegree.length;
        
        for(int i=0;i<n;i++) 
            for(int it : adj.get(i))
                indegree[it] += 1;
    }
    
    public boolean canFinish(int n, int[][] pre) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        build(pre, n, adj);
        
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        findIndegree(adj, indegree);
        
        for(int i=0;i<n;i++)
            if(indegree[i] == 0)
                queue.offer(i);
                
        int cnt = 0;
                
        while(!queue.isEmpty()) {
            int node = queue.poll();
            cnt += 1;
            
            for(int it : adj.get(node)) {
                indegree[it] -= 1;
                
                if(indegree[it] == 0)
                    queue.offer(it);
            }
        }
        
        if(cnt == n)
            return true;
            
        return false;
    }
}