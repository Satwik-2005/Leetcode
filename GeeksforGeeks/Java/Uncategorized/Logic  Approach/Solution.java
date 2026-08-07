class Solution {
    public int countFriendsPairings(int n) {
        return singleOrPair(n);
    }
    
    private int singleOrPair(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
    
        return singleOrPair(n - 1)
               + (n - 1) * singleOrPair(n - 2);
    }
}
