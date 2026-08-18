class Solution {
    public String compress(String s) {
        int n = s.length();

        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 1; i--) {
            dp[i] = 1 + dp[i + 1];

            if (2 * i <= n && z[i] >= i) {
                dp[i] = Math.min(dp[i], 1 + dp[2 * i]);
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < n) {

            if (i == 0) {
                ans.append(s.charAt(0));
                i = 1;
                continue;
            }

            boolean canStar = false;

            if (2 * i <= n && z[i] >= i) {
                canStar = (dp[i] == 1 + dp[2 * i]);
            }

            if (canStar) {
                ans.append('*');
                i = 2 * i;
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}