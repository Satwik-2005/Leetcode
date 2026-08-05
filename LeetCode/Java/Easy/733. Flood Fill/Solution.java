class Solution {

    private void dfs(int sr, int sc, int[][] image, int color, int n, int m, int[] delRow, int[] delCol, int ini) {
        image[sr][sc] = color;

        for(int i=0;i<4;i++) {
                int newRow = sr + delRow[i];
                int newCol = sc + delCol[i];

                if(
                    newRow >= 0  &&  newCol >= 0  &&  newRow < n  &&  newCol < m  &&
                    image[newRow][newCol] == ini
                )
                    dfs(newRow, newCol, image, color, n, m, delRow, delCol, ini);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int initialColor = image[sr][sc];

        if(initialColor == color)
            return image;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        dfs(sr, sc, image, color, n, m, delRow, delCol, initialColor);

        return image;
    }
}