class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }

        if(word.charAt(idx) != board[i][j]){
            return false;
        }

        if(idx == word.length() - 1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        for(int[] dir : dirs){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(dfs(board, word, newI, newJ, idx + 1)){
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
