class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == '.')
                    continue;

                int d = board[i][j] - '1';
                int c = (i / 3) * 3 + (j / 3);

                if(row[i][d]  ||  col[j][d]  ||  boxes[c][d])
                    return false;

                row[i][d] = true;
                col[j][d] = true;
                boxes[c][d] = true;
            }
        }

        return true;
    }
}