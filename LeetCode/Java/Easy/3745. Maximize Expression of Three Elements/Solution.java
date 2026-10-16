class Solution {

    private int[] largestAndSecond(int[] nums, int n) {
        int largest = nums[0];
        int secondLargest = -1;
        int smallest = nums[0];

        for(int i=1;i<n;i++) {
            if(nums[i] >= largest) {
                secondLargest = largest;
                largest = nums[i];
            }

            else if(nums[i] < largest  &&  nums[i] > secondLargest)
                secondLargest = nums[i];

            smallest = Math.min(smallest, nums[i]);
        }

        return new int[]{largest, secondLargest, smallest};
    }

    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;

        int[] arr = largestAndSecond(nums, n);

        int largest = arr[0];
        int secondLargest = arr[1];
        int smallest = arr[2];

        System.out.println(smallest + " " + secondLargest + " " + largest);

        return largest + secondLargest - smallest;
    }
}