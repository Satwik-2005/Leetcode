class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(!deque.isEmpty()  &&  deque.getFirst() <= i - k)
                deque.pollFirst();

            while(!deque.isEmpty()  &&  nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            deque.offerLast(i);

            if(i >= k - 1)
                list.add(nums[deque.peekFirst()]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}