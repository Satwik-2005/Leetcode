class Solution {
    
     static int helper(int index, int sum, int[] arr, int[][] dp) {
        if(index == 0) {
            if(arr[0] == 0 && sum == 0)
                return 2;   
            if(arr[0] == sum || sum == 0)
                return 1;
            return 0;
        }
        
        if(dp[index][sum] != -1)
            return dp[index][sum];

        int notTake = helper(index - 1, sum, arr, dp);
        int take = 0;

        if(arr[index] <= sum)
            take = helper(index - 1, sum - arr[index], arr, dp);

        return dp[index][sum] = take + notTake;
    }
    
    static int helper(int index, int sum, int[] arr) {
        if(index == 0) {
            if(arr[0] == 0 && sum == 0)
                return 2;   
            if(arr[0] == sum || sum == 0)
                return 1;
            return 0;
        }

        int notTake = helper(index - 1, sum, arr);
        int take = 0;

        if(arr[index] <= sum)
            take = helper(index - 1, sum - arr[index], arr);

        return take + notTake;
    }
    
    static int perfectSum(int[] arr, int target) {
        // code here
        int n = arr.length;
        
        int[][] dp = new int[(int) (1e3 + 1)][(int) (1e3 + 1)];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return helper(n - 1, target, arr, dp);
    }
}