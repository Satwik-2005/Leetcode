class Solution {

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void permutations2(int index, int[] nums, int n, Set<List<Integer>> permutations) {
        if(index == n) {
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<n;i++)
                list.add(nums[i]);

            permutations.add(list);
            return;
        }

        for(int i=index;i<n;i++) {
            swap(i, index, nums);
            permutations2(index + 1, nums, n, permutations);
            swap(i, index, nums);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        
        Set<List<Integer>> permutations = new HashSet<>();

        permutations2(0, nums, n, permutations);

        return new ArrayList<>(permutations);
    }
}