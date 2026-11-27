class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        
        int left = 0;
        int right = 0;
        int zeroes = 0;
        int maximumLength = 0;

        while(right < n) {
            if(nums[right] == 0)
                zeroes += 1;

            while(zeroes > k) {
                if(nums[left] == 0) 
                    zeroes -= 1;

                left += 1;
            }

            if(zeroes <= k) {
                int len = right - left + 1;

                maximumLength = Math.max(maximumLength, len);
            }

            right += 1;
        }

        return maximumLength;
    }
}