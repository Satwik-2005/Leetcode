class Solution {
    
    static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[(int) (10e3 + 1)];

        prev[0] = true;
        prev[arr[0]] = true;

        for(int index=1;index<n;index++) {
            boolean[] curr = new boolean[(int) (10e3 + 1)];

            curr[0] = true;

            for(int target=1;target<=sum;target++) {
                boolean notTake = prev[target];
                boolean take = false;

                if(arr[index] <= target)
                    take = prev[target - arr[index]];

                    curr[target] = take || notTake;
                }

                prev = curr;
            }
            
        return prev[sum];
    }
    
    private static int sum(int[] arr, int n) {
        int sum = 0;
        
        for(int ele : arr)
            sum += ele;
            
        return sum;
    }
    
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        
        int sum = sum(arr, n);
        
        return (sum % 2) == 0 ? subsetSum(arr, sum / 2) : false;
    }
}