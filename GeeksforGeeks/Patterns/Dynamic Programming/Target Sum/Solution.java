class Solution {
    
    int subsetCount(int index , int sum , int[] nums , int[][] dp) {
        if(index == 0) {
            if(sum == 0 && nums[0] == 0)
                return 2;

            if(sum == 0 || sum == nums[0])
                return 1;

            return 0;
        }

        if(dp[index][sum] != -1)
            return dp[index][sum];

        int notTake = subsetCount(index - 1 , sum , nums , dp);
        int take = 0;

        if(nums[index] <= sum)
            take = subsetCount(index - 1 , sum - nums[index] , nums , dp);

        return dp[index][sum] = take + notTake;
    }

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for(int[] row : dp)
            Arrays.fill(row , -1);

        return subsetCount(n - 1 , target , nums , dp);
    }

    public int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int totalSum = 0;

        for(int element : arr)
            totalSum += element;

        if((totalSum - diff) < 0  ||  ((totalSum - diff) % 2) == 1)
            return 0;

        return perfectSum(arr , (totalSum - diff) / 2);
    }
    
    public int totalWays(int[] arr, int target) {
        // code here
        return countPartitions(arr, target);
    }
}