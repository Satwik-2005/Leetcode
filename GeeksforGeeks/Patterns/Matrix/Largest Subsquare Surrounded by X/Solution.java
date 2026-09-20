class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;

        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        // Count consecutive X to the right and downward
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (mat[i][j] == 'X') {

                    right[i][j] = 1;
                    down[i][j] = 1;

                    if (j + 1 < n)
                        right[i][j] += right[i][j + 1];

                    if (i + 1 < n)
                        down[i][j] += down[i + 1][j];
                }
            }
        }

        int ans = 0;

        // Try every cell as top-left corner
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int size = Math.min(right[i][j], down[i][j]);

                // Try largest possible square first
                while (size > ans) {

                    int bottom = i + size - 1;
                    int rightCol = j + size - 1;

                    // Check bottom side and right side
                    if (right[bottom][j] >= size &&
                        down[i][rightCol] >= size) {

                        ans = size;
                        break;
                    }

                    size--;
                }
            }
        }

        return ans;
    }
}