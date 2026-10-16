class Solution {
    public void arrange(int[] arr) {
        // code here
        int n = arr.length;
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++)
            nums[i] = arr[arr[i]];
            
        for(int i=0;i<n;i++)
            arr[i] = nums[i];
    }
}