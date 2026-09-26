class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int longest = 1;
        
        for(int i : arr)
            set.add(i);
            
        for(int element : set) {
            if(!set.contains(element - 1)) {
                int count = 1;
                int x = element;
                
                while(set.contains(x + 1)) {
                    x += 1;
                    count++;
                }
                
                longest = Math.max(longest , count);
            }
        }
        
        return longest;
    }
}