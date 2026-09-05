class Solution {
    
    // static boolean subsetSumEqualsK(int index, int target, int[] arr, int[][] dp) {
    //     if(target == 0)
    //         return true;
            
    //     if(index == 0)
    //         return (arr[index] == target);
            
    //     if(dp[index][target] != -1)
    //         return true;
            
    //     boolean notTake = subsetSumEqualsK(index - 1, target, arr, dp);
    //     boolean take = false;
        
    //     if(arr[index] <= target) 
    //         take = subsetSumEqualsK(index - 1, target - arr[index], arr, dp);
        
    //     boolean result = (take || notTake);
    //     dp[index][target] = result ? 1 : -1;
        
    //     return result;
    // }
    
    // static boolean subsetSumEqualsK(int index, int target, int[] arr) {
    //     if(target == 0)
    //         return true;
            
    //     if(index == 0)
    //         return (arr[index] == target);
            
    //     boolean notTake = subsetSumEqualsK(index - 1, target, arr);
    //     boolean take = false;
        
    //     if(arr[index] <= target) 
    //         take = subsetSumEqualsK(index - 1, target - arr[index], arr);
        
    //     return (take || notTake);
    // }
    
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        
        boolean[][] dp = new boolean[201][(int) (10e3 + 1)];
        
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        
        // return subsetSumEqualsK(n - 1, sum, arr, dp);
        
        for(int i=0;i<n;i++)
            dp[i][0] = true;
            
        dp[0][arr[0]] = true;
        
        for(int index=1;index<n;index++) {
            for(int target=1;target<=sum;target++) {
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                
                if(arr[index] <= target)
                    take = dp[index - 1][target - arr[index]];
                    
                dp[index][target] = take || notTake;
            }
        }
        
        return dp[n - 1][sum];
    }
}