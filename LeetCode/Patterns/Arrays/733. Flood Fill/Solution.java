class Solution {

    static void dfs(int row , int col , int [][]finalColor , int [][]image , 
                    int color , int []delRow , int []delCol , int location) {
        

        finalColor[row][col] = color;

        int m = image.length;
        int n = image[0].length;

        for(int i=0;i<4;i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0  &&  nRow <m  &&  nCol >= 0  &&  nCol < n 
                &&  image[nRow][nCol] == location  &&  finalColor[nRow][nCol] != color)
                    dfs(nRow , nCol , finalColor , image , color , delRow , delCol , location);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int [][]finalColor = image;
        int location = image[sr][sc];
        int []delRow = {-1 , 0 , 1 , 0};
        int []delCol = {0 , 1 , 0 , -1};

        dfs(sr , sc , finalColor , image , color , delRow , delCol , location);

        return finalColor;
    }
}