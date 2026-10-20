class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            int score = 0;

            for(int j = i; j < n; j++) {
                score += (nums[j] == target) ? 1 : -1;

                if(score > 0)
                    count++;
            }
        }

        return count;
    }
}