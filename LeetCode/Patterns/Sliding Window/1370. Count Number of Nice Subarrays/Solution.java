class Solution {

    int binarySubarray(int[] nums , int goal) {
        if(goal < 0) return 0;

        int sum = 0;
        int count = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length) {
            sum += (nums[right] % 2);

            while(sum > goal) {
                sum = sum - (nums[left] % 2);

                left += 1;
            }

            count += (right - left + 1);

            right += 1;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return binarySubarray(nums , k) - binarySubarray(nums , k - 1);
    }
}