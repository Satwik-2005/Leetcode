class Solution {
    public int minCount(int[] arr) {
        // code here
        int n = arr.length;
        int[][][] dp = new int[n][n+1][n+1];
        for(int[][] r1:dp){
            for(int[] r:r1){
                Arrays.fill(r,-1);
            }
        }
        return n - solve(0,-1,-1,arr,dp);
    }

    public int solve(int idx,int Incprev,int Decprev,int[] arr,int[][][] dp){

        if(idx == arr.length) return 0;
        if(dp[idx][Incprev+1][Decprev+1] != -1) return dp[idx][Incprev+1][Decprev+1];
        int len = 0;
        len = solve(idx+1,Incprev,Decprev,arr,dp);
        if(Incprev == -1 || arr[idx]> arr[Incprev]){
            len = Math.max(len,1+solve(idx+1,idx,Decprev,arr,dp));
        }
        if(Decprev == -1 || arr[idx]<arr[Decprev]){
            len = Math.max(len,1+solve(idx+1,Incprev,idx,arr,dp));
        }
    return dp[idx][Incprev+1][Decprev+1] = len;
    }

}