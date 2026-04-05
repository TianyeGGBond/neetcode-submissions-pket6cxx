class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int rows, cols;
    boolean[][] remainX;
    
    public void solve(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.remainX = new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++){
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        for(int j = 0; j < cols; j++){
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && !remainX[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r , int c){
        if (board[r][c] == 'X') return;

        remainX[r][c] = true;

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < rows &&
                nc >= 0 && nc < cols &&
                board[nr][nc] == 'O' &&
                !remainX[nr][nc]){
                dfs(board, nr, nc);
            }
        }

    }
}
