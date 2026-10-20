class Solution {

    private int sum(int[] rewardValues) {
        int n = rewardValues.length;
        int sum = 0;

        for(int i=0;i<n;i++) 
            sum += rewardValues[i];

        return sum;
    }

    private int solve(int index, int sum, int[] arr) {
        if(index == arr.length)
            return sum;

        int notTake = solve(index + 1, sum, arr);
        int take = 0;

        if(arr[index] > sum)
            take = solve(index + 1, sum + arr[index], arr);

        return Math.max(take, notTake);
    }

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        int max = sum(rewardValues);

        int[][] dp = new int[n][max];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, rewardValues, );
    }
}