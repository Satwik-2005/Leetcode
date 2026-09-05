class Solution {
    public int minDifference(int arr[]) {
        int n = arr.length;
        int totalSum = 0;

        for(int ele : arr)
            totalSum += ele;

        boolean[][] dp = new boolean[n][totalSum + 1];

        for(int i = 0; i < n; i++)
            dp[i][0] = true;

        if(arr[0] <= totalSum)
            dp[0][arr[0]] = true;

        for(int index = 1; index < n; index++) {
            for(int t = 1; t <= totalSum; t++) {
                boolean notTake = dp[index - 1][t];
                boolean take = false;

                if(arr[index] <= t)
                    take = dp[index - 1][t - arr[index]];

                dp[index][t] = take || notTake;
            }
        }

        int mini = (int) (1e8);

        for(int s1 = 0; s1 <= totalSum / 2; s1++) {
            if(dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                mini = Math.min(mini, Math.abs(s2 - s1));
            }
        }

        return mini;
    }
}