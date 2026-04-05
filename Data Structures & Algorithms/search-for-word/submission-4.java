class Solution {
    private int r, c;

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(dfs(board, word, i,j, 0)){
                    return true;
                }
            }
        }

        return false;
    }
    
    private boolean dfs(char[][] board, String word, int n, int m, int i){
        if(i == word.length()){
            return true;
        }

        if( n < 0 || n >= r || m < 0 || m >= c 
            || board[n][m] != word.charAt(i)
            || board[n][m] == '#'){
            return false;
        }

        board[n][m] = '#';

        boolean res = 
            dfs(board, word, n, m + 1, i + 1) ||
            dfs(board, word, n + 1, m, i + 1) ||
            dfs(board, word, n, m - 1, i + 1) ||
            dfs(board, word, n - 1, m, i + 1) ;

        board[n][m] = word.charAt(i);

        return res;
    }
}
