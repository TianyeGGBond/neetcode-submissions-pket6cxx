public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean word;

    public TrieNode() {
        children = new HashMap<>();
        word = false;
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // 添加单词
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            // 如果没有对应分支，就新建
            cur.children.putIfAbsent(c, new TrieNode());
            // 移动到下一个节点
            cur = cur.children.get(c);
        }
        // 单词结束
        cur.word = true;
    }

    // 搜索（支持 '.' 通配符）
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS 搜索
    private boolean dfs(String word, int j, TrieNode node) {
        TrieNode cur = node;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // '.' 可以匹配任意一个子节点
                for (TrieNode child : cur.children.values()) {
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
        return cur.word;
    }
}
