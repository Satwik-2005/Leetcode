class Solution {

    private void pass(int[] nums, Set<Integer> set) {
        for(int number : nums)
            set.add(number);
    }

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        pass(nums, set);

        int i = 1;
        int temp1 = 0;

        while(true) {
            int temp = k * i;

            if(!set.contains(temp)) {
                temp1 = temp;
                break;
            }

            i += 1;
        }

        return temp1;
    }
}