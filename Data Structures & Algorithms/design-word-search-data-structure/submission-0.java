public class Node{
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
        return;
    }
    public boolean search(String word) {
            return dfs(word, 0, root);
        }

        // DFS 搜索
        private boolean dfs(String word, int j, Node node) {
            Node cur = node;
            for (int i = j; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    // '.' 可以匹配任意一个子节点
                    for (Node child : cur.children.values()) {
                        if (dfs(word, i + 1, child)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    if (!cur.children.containsKey(c)) {
                        return false;
                    }
                    cur = cur.children.get(c);
                }
            }
            return cur.isEnd;
        }

}
