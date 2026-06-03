class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;
    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    private void insertWord(String word){
        if(word.length() == 0) return;

        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null) cur.children[i] = new TrieNode();
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        //build dictionary
        root = new TrieNode();
        for(String word : words){
            insertWord(word);
        }

        //dfs for board
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, res, sb, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, List<String> res, StringBuilder sb, TrieNode cur){
        if(cur.isEnd){
            res.add(sb.toString());
            cur.isEnd = false;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }

        char c = board[i][j];
        if(c == '#') return;

        int idx = c - 'a';
        if(cur.children[idx] == null) return;

        sb.append(c);
        board[i][j] = '#';

        for(int[] dir : dirs){ //TODO
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            dfs(board, newI, newJ, res, sb, cur.children[idx]);
        }

        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = c;
    }
}
