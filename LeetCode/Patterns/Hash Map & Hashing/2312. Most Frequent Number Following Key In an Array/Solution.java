class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int max = (int) (-1e9);

        for(int i=0;i<n-1;i++) {
            if(nums[i] == key) {
                int value = nums[i + 1];

                map.put(value, map.getOrDefault(value, 0) + 1);
                max = Math.max(max, map.get(value));
            }
        }

        int index = 0;

        for(int key1 : map.keySet())
            if(map.get(key1) == max)
                index = key1;

        return index;
    }
}