class Solution {
    
    private int minimumCost(int i, int j, List<Integer> list, int[][] dp) {
        if(i > j)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int minimum = (int) (1e9);
            
        for(int index=i;index<=j;index++) {
            int cost = (list.get(j + 1) - list.get(i - 1)) + 
                        minimumCost(i, index - 1, list, dp) +
                        minimumCost(index + 1, j, list, dp);
                        
            minimum = Math.min(minimum, cost);
        }
        
        return dp[i][j] = minimum;
    }
    
    private int minimumCost(int i, int j, List<Integer> list) {
        if(i > j)
            return 0;
            
        int minimum = (int) (1e9);
            
        for(int index=i;index<=j;index++) {
            int cost = (list.get(j + 1) - list.get(i - 1)) + 
                        minimumCost(i, index - 1, list) +
                        minimumCost(index + 1, j, list);
                        
            minimum = Math.min(minimum, cost);
        }
        
        return minimum;
    }
    
    private void insert(int[] cuts, int n, int c, List<Integer> list) {
        list.add(0);
        
        for(int i=0;i<c;i++)
            list.add(cuts[i]);
            
        list.add(n);
    }
    
    public int minCutCost(int n, int[] cuts) {
        // code here
        List<Integer> list = new ArrayList<>();
        int c = cuts.length;
        
        insert(cuts, n, c, list);
        
        Collections.sort(list);
        
        int[][] dp = new int[c + 1][c + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return minimumCost(1, c, list, dp);
    }
}
