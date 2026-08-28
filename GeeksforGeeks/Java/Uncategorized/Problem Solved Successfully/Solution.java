// class Solution {
//     public int minCost(int[][] mat) {
//         // code here
        
//     }
// }


class Solution {
    public int minCost(int[][] mat) {
        // code here
        int l=mat.length;
        int[][] dp=new int[l+1][3];
        for(int i=0;i<l;i++){
            dp[i+1][0]=mat[i][0]+Math.min(dp[i][1],dp[i][2]);
            dp[i+1][1]=mat[i][1]+Math.min(dp[i][0],dp[i][2]);
            dp[i+1][2]=mat[i][2]+Math.min(dp[i][0],dp[i][1]);
        }
        return Math.min(dp[l][0],Math.min(dp[l][1],dp[l][2]));
    }
}