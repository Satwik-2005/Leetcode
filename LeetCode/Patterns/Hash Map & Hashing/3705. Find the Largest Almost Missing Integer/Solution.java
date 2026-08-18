class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<=n-k;i++){
            Set<Integer> hashSet = new HashSet<>();
            for(int j=i;j<i+k;j++){
                if(!hashSet.contains(nums[j])){
                    hashMap.put(nums[j],hashMap.getOrDefault(nums[j],0)+1);
                    hashSet.add(nums[j]);
                }
            }
        }
        int missing = -1;
        for(Map.Entry<Integer,Integer> ele : hashMap.entrySet())
            if(ele.getValue() == 1)
                missing = Math.max(missing,ele.getKey());
        return missing;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna