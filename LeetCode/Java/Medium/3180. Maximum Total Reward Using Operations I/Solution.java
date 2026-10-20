class Solution {

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
        return solve(0, 0, rewardValues);
    }
}