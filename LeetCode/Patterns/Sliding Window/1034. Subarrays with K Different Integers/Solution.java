class Solution {

    private int subarrayDistinct(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while(right < n) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while(map.size() > k) {
                int number = nums[left];
                map.put(number, map.getOrDefault(number, 0) - 1);

                if(map.get(number) == 0)
                    map.remove(number);

                left += 1;
            }

            count += (right - left + 1);

            right += 1;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayDistinct(nums, k) - subarrayDistinct(nums, k - 1);
    }
}