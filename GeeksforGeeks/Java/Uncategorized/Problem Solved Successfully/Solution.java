class Solution {
    public int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int perimeter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1) {
                    perimeter += 4;


                    if (i > 0 && mat[i - 1][j] == 1) {
                        perimeter -= 2;
                    }


                    if (j > 0 && mat[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}