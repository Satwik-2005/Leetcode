class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0;i<n;i++)
            set.add(nums[i]);

        int count = 0;
        int maxLength = 0;

        for(int element : set) {
            int previous = element - 1;

            if(!set.contains(previous)) {
                count = 1;
                int x = element;

                while(set.contains(x + 1)) {
                    count += 1;
                    x += 1;
                }

                maxLength = Math.max(maxLength , count);
            }
        }

        return maxLength;
    }
}