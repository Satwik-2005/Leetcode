class Pair {
    int first;
    int second;
    
    public Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        if(start == end)
            return 0;
        
        int n = arr.length;
        
        Queue<Pair> queue = new LinkedList<>();
        int[] dist = new int[1000];
        
        Arrays.fill(dist, (int) (1e9));
        
        queue.offer(new Pair(start, 0));
        dist[start] = 0;
        
        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            
            int val = node.first;
            int count = node.second;
            
            for(int i=0;i<n;i++) {
                int num = (arr[i] * val) % 1000;
                    
                if(num == end)
                    return count + 1;
                
                if(count + 1  <  dist[num]) {
                    dist[num] = count + 1;
                    
                        
                    queue.offer(new Pair(num, count + 1));
                }
            }
        }
        
        
        return -1;
    }
}