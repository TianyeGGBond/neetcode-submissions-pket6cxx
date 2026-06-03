class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null){
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        return dfs(word, 0, cur);
    }

    private boolean dfs(String word, int layer, TrieNode cur){
        if(layer == word.length()){
            return cur.isEnd;
        }

        char c = word.charAt(layer);
        if(c != '.'){
            int idx = c - 'a';
            if(cur.children[idx] == null) return false;
            return dfs(word, layer+1, cur.children[idx]);
        }else{
            for(int x = 0; x < 26; x++){
                if(cur.children[x] == null) continue;
                if(dfs(word, layer+1, cur.children[x])){
                    return true;
                }
            }
        }
        return false;
    }
}
