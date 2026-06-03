class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, res, 0);
        return res;

    }

    private void dfs(char[][] board, List<List<String>> res, int line){
        if(line == board.length){
            List<String> temp = new ArrayList<>();
            for(char[] row : board){
                temp.add(new String(row));
            }
            res.add(temp);
            return;
        }

        for(int i = 0; i < board.length; i++){
            if(!valid(board, line, i)) continue;

            board[line][i] = 'Q';
            dfs(board, res, line + 1);
            board[line][i] = '.';
        }
    }

    private boolean valid(char[][] board, int r, int c){
        // vertically
        for(int i = r - 1; i >= 0; i--){
            if(board[i][c] == 'Q') return false;
        }

        //diagonally left
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        //diagonally right
        for(int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}
