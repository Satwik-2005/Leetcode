class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int leftSum = 0;
        int rightSum = 0;
        int right = n - 1;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<k;i++)
            leftSum += cardPoints[i];

        maxSum = Math.max(maxSum, leftSum);

        for(int i=k-1;i>=0;i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[right];

            right -= 1;

            maxSum = Math.max(maxSum, rightSum + leftSum);
        }

        return maxSum;
    }
}