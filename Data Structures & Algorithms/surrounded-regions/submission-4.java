class Solution {
    int[][] dirs = {{1,0} , {-1,0}, {0,-1}, {0,1}};
    int row, col;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                drain(board, i, 0);
            }
            if(board[i][col - 1] == 'O'){
                drain(board, i , col-1);
            }
        }

        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O'){
                drain(board, 0, j);
            }
            
            if(board[row - 1][j] == 'O'){
                drain(board, row-1, j);
            }            
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    private void drain(char[][] board, int r, int c){
        if(r < 0 || r >= row || c < 0 || c >= col 
        || board[r][c] == 'X' || board[r][c] == 'N'){
            return;
        }

        if(board[r][c] == 'O'){
            board[r][c] = 'N';
        }

        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            drain(board, newR, newC);
        }
    }
}
