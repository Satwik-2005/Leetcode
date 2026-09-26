class Solution {

    Integer[][] dp;

    public int solve(int[] units , int[] costs , int i , int area, int x){
        if(i == 3){
            if(area < x){
                return Integer.MAX_VALUE;
            }
            return 0;
        }
        if(area >= x){
            return 0;
        }
        if(dp[i][area] != null){
            return dp[i][area];
        }
        int minCost = Integer.MAX_VALUE;
        int skip = solve(units , costs , i+1, area, x);
        minCost = Math.min(minCost , skip);
        int take = solve(units , costs , 0 , area+units[i], x);
        if(take != Integer.MAX_VALUE){
            take += costs[i];
            minCost = Math.min(minCost , take);
        }
        return dp[i][area] = minCost;
    }
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
        int[] units = new int[3];
        int[] costs = new int[3];
        units[0] = s; units[1] = m ; units[2] = l;
        costs[0] = cs ; costs[1] = cm ; costs[2] = cl;
        dp = new Integer[4][501];
        return solve(units , costs , 0 , 0, x);
    }
}