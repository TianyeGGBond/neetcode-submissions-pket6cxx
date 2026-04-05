class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        for(int i = 0; i < n; i++){
            // row board[i][j]
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                char cur = board[i][j];
                if(cur != '.' ){
                    if(set.contains(cur)) return false;
                    set.add(cur);
                } 
            }
            set.clear();

            //col board[k][i]
            for(int k = 0; k < n; k++){
                char cur = board[k][i];
                if( cur != '.' ){
                    if(set.contains(cur)) return false;
                    set.add(cur);
                } 
            }
            set.clear();


            //sub box i 
            int row = i / 3;
            int col = i % 3;
            for(int z = 0; z < n; z++){
                char cur = board[z/3 + row*3][z%3 + col * 3];
                if( cur != '.' ){
                    if(set.contains(cur)) return false;
                    set.add(cur);
                }
            }
            set.clear();
        }
        return true;
    }
}
