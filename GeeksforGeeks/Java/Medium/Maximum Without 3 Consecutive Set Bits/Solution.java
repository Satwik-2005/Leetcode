class Solution {
    public int maxValue(int n) {
        int run = 0;
        for (int b = 30; b >= 0; b--) {
            if ((n >> b & 1) == 0) {
                run = 0;
            } else if (run == 2) {
                n &= ~(1 << b);
                run = 0;
            } else {
                run++;
            }
        }
        return n;
    }
}