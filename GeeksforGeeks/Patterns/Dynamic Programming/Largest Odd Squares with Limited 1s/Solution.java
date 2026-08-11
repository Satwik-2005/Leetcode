class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Build 2D prefix sum matrix
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        
        // Helper to get sum of rectangle
        java.util.function.BiFunction<int[], int[], Integer> getSum = (range1, range2) -> {
            int r1 = range1[0], c1 = range1[1];
            int r2 = range2[0], c2 = range2[1];
            return pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];
        };
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];
            
            // If center itself exceeds k
            if (mat[r][c] > k) {
                ans.add(-1);
                continue;
            }
            
            int maxD = Math.min(Math.min(r, n - 1 - r), Math.min(c, m - 1 - c));
            int low = 0, high = maxD;
            int bestD = 0;
            
            while (low <= high) {
                int mid = (low + high) / 2;
                int onesCount = getSum.apply(
                    new int[]{r - mid, c - mid},
                    new int[]{r + mid, c + mid}
                );
                
                if (onesCount <= k) {
                    bestD = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            ans.add(2 * bestD + 1);
        }
        
        return ans;
    }
}