class Solution {
    
    private int maxSum(int[] nums) {
        int n = nums.length;
        
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i=1;i<n;i++) {
            int take = nums[i];
            
            if(i > 1)
                take += prev2;
                
            int notTake = 0 + prev;
            int curr = Math.max(take, notTake);
            
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
    
    public int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        
        int index1 = 0;
        int index2 = 0;
        
        for(int i=0;i<n;i++) {
            if(i != 0)
                temp1[index1++] = arr[i];
                
            if(i != n - 1)
                temp2[index2++]  = arr[i];
        }
        
        return Math.max(maxSum(temp1), maxSum(temp2));
    }
}
