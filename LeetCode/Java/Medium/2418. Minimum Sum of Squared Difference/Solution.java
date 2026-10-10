class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;   // only the total matters

        int max = 0;
        for(int i = 0; i < n; i++)
            max = Math.max(max, Math.abs(nums1[i] - nums2[i]));

        // cnt[d] = how many positions currently have a gap of exactly d
        long[] cnt = new long[max + 1];
        for(int i = 0; i < n; i++)
            cnt[Math.abs(nums1[i] - nums2[i])]++;

        // shave the biggest gaps first
        for(int d = max; d >= 1 && k > 0; d--) {
            if(cnt[d] == 0)
                continue;

            if(k >= cnt[d]) {          // enough moves to push every gap of size d down by 1
                k -= cnt[d];
                cnt[d - 1] += cnt[d];
                cnt[d] = 0;
            } else {                   // only enough moves for some of them
                cnt[d] -= k;
                cnt[d - 1] += k;
                k = 0;
            }
        }

        long result = 0;
        for(int d = 1; d <= max; d++)
            result += cnt[d] * (long) d * d;

        return result;
    }
}