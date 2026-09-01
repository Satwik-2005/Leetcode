class Solution {

    static final long MOD = 1_000_000_007L;

    public int palindromicStrings(int n, int k) {

        long ans = 0;

        // perm = P(k, m)
        // Initially P(k, 0) = 1
        long perm = 1;

        // m = number of characters in the first half
        for (int m = 0; 2 * m <= n; m++) {

            if (m > 0) {
                perm = (perm * (k - m + 1)) % MOD;
            }

            // Odd length = 2*m + 1
            if (2 * m + 1 <= n) {
                long oddCount = (perm * (k - m)) % MOD;
                ans = (ans + oddCount) % MOD;
            }

            // Even length = 2*m
            if (m > 0 && 2 * m <= n) {
                ans = (ans + perm) % MOD;
            }
        }

        return (int) ans;
    }
}

