class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int V = adj.size();
        
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            int val = queue.poll();
            list.add(val);
            
            
            
            for(int it : adj.get(val)) {
                if(visited[it] == false) {
                    queue.offer(it);
                    visited[it] = true;
                }
            }
        }
        
        return list;
    }
}