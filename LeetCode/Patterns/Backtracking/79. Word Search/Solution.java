class Solution {

    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};

    private boolean dfs(int row, int col, char[][] board, String word, boolean[][] visited, int index) {
        if(index == word.length())
            return true;   // full word matched

        int n = board.length;
        int m = board[0].length;

        visited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(
                newRow >= 0  &&  newRow < n  && 
                newCol >= 0  &&  newCol < m  &&
                !visited[newRow][newCol]  &&
                board[newRow][newCol] == word.charAt(index)
            ) {
                if(dfs(newRow, newCol, board, word, visited, index + 1))
                    return true;   // propagate success up
            }
        }

        visited[row][col] = false;  // backtrack — free this cell for other paths
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {   // fixed: m, not n
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, board, word, visited, 1))
                        return true;
                }
            }
        }

        return false;
    }
}