public class Node{
    Map<Character,Node> children = new HashMap<>();
    String isEnd;
}

ArrayList<String> res = new ArrayList<>();

class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        //build trie
        Node root = new Node();
        for(String word : words){
            Node cur = root;
            for(char c: word.toCharArray()){
                cur.children.putIfAbsent(c, new Node());
                cur = cur.children.get(c);
            }
            cur.isEnd = word;
        }

        //searching 
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i,j,board, root);
            }
        }
        return res;
    }
    public final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void dfs(int n, int m, char[][] board, Node parent){
        if(n < 0 || n >= board.length || m < 0 || m >= board[0].length) return;
        char c = board[n][m];
        if(c == '#' || !parent.children.containsKey(c)) return;
        board[n][m] = '#';

        Node cur = parent.children.get(c);
        if(cur.isEnd != null){
            res.add(cur.isEnd);
            cur.isEnd = null;
        }
        for(int[] dir: dirs){
            int nn = n + dir[0];
            int nm = m + dir[1];
            dfs(nn, nm, board, cur);
        }
        board[n][m] = c;
        
    }

}
