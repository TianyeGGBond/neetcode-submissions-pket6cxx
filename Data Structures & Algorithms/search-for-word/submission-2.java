//79
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int r = 0; r< row; r++){
            for(int c = 0; c < col; c++){
                if(bt(board, word, new boolean[row][col], r,c,0)) return true;
            }
        }
        return false;
    }
    private boolean bt(char[][] board, String word, boolean[][] visited, int r, int c, int i){
        if(i == word.length()) return true;

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length 
        || board[r][c] !=  word.charAt(i) || visited[r][c])
        return false;

        visited[r][c] = true;
        boolean res = bt(board, word, visited, r+1, c, i+1) ||
                      bt(board, word, visited, r-1, c, i+1) ||
                      bt(board, word, visited, r, c+1, i+1) ||
                      bt(board, word, visited, r, c-1, i+1) ;
        if(!res) visited[r][c] = false;
        return res;
}                     
}