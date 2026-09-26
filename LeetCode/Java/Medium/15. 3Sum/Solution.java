class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        List<List<Integer>> uniquePairs = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(i > 0  &&  nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;
             
            while(j < k) {
                int target = nums[i] + nums[j] + nums[k];

                if(target < 0)
                    j += 1;

                else if(target > 0)
                    k -= 1;

                else {
                    uniquePairs.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j += 1;
                    k -= 1;

                    while(j < k  &&  nums[j] == nums[j - 1])
                        j += 1;

                    while(j < k  &&  nums[k] == nums[k + 1])
                        k -= 1;
                }
            }
        }

        return uniquePairs;
    }
}