class Solution {

    private void dfs(int row, int col, char[][] board, int[][] visited, int[] delRow, int[] delCol) {
        int n = board.length;
        int m = board[0].length;

        visited[row][col] = 1;

        for(int i=0;i<4;i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(
                newRow >= 0  &&  newCol >= 0  &&
                newRow < n  &&  newCol < m  && 
                visited[newRow][newCol] == 0  &&
                board[newRow][newCol] == 'O'
            ) 
                dfs(newRow, newCol, board, visited, delRow, delCol);
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int j=0;j<m;j++) {
            if(visited[0][j] == 0  &&  board[0][j] == 'O')
                dfs(0, j, board, visited, delRow, delCol);

            if(visited[n - 1][j] == 0  &&  board[n - 1][j] == 'O')
                dfs(n - 1, j, board, visited, delRow, delCol);
        }

        for(int i=0;i<n;i++) {
            if(visited[i][0] == 0  &&  board[i][0] == 'O')
                dfs(i, 0, board, visited, delRow, delCol);

            if(visited[i][n - 1] == 0  &&  board[i][n - 1] == 'O')
                dfs(i, n - 1, board, visited, delRow, delCol);
        }


        for(int i=0;i<n;i++) 
            for(int j=0;j<m;j++)
                if(board[i][j] == 'O'  && visited[i][j] == 0)
                    board[i][j] = 'X';
    }
}