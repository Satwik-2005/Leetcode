class Solution {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int findLowestElement(int[] nums , int n) {
        int index = -1;

        for(int i=n-2;i>=0;i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void reverse(int[] nums, int low, int high) {
        while(low < high) {
            swap(nums, low, high);

            low++;
            high--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int mid = findLowestElement(nums , n);

        if(mid == -1)
            reverse(nums, 0, n - 1);

        else{
            for(int i=n-1;i>=mid;i--) {
                if(nums[i] > nums[mid]) {
                    swap(nums , i , mid);
                    break;
                }
            }
            
            reverse(nums , mid + 1 , n - 1);
        }
    }
}