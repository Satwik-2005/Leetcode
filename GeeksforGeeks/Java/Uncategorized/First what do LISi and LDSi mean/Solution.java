class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        int maximum = 0;
        
        for(int index=0;index<n;index++) {
            for(int prevIndex=0;prevIndex<index;prevIndex++) {
                if(nums[prevIndex] < nums[index]  &&  1 + dp1[prevIndex] > dp1[index])
                    dp1[index] = 1 + dp1[prevIndex];
            }
        }
        
        for(int index=n-1;index>=0;index--) {
            for(int prevIndex=n-1;prevIndex>index;prevIndex--) {
                if(nums[prevIndex] < nums[index]  &&  1 + dp2[prevIndex] > dp2[index])
                    dp2[index] = 1 + dp2[prevIndex];
            }
        }
        
        for(int i=0;i<n;i++)
            if(dp1[i] > 1  &&  dp2[i] > 1)
                maximum = Math.max(maximum, dp1[i] + dp2[i] - 1);
            
        return maximum;
    }
}
