class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(nge, -1);

        for(int i=((2*n)-1);i>=0;i--) {
            while(!stack.isEmpty()  &&  stack.peek() <= nums[i % n])
                stack.pop();

            if(i < n  &&  !stack.isEmpty())
                nge[i] = stack.peek();

            stack.push(nums[i % n]);
        }

        return nge;
    }
}