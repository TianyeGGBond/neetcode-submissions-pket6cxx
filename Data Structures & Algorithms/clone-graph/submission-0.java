/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//133
//这题的新点存在hashmap里，key是old，value是new，
//步骤：新建点（val）- 增加新点neighber
class Solution {
    Map<Node,Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node node) {
        //node不存在和为空怎么写要看一下
        if(node == null) return null;
        dfs(node);
        return oldToNew.get(node);
    }
    private void dfs(Node node){
        if(node == null) return;
        if(oldToNew.containsKey(node)) return;
        Node cur = new Node(node.val);
        oldToNew.put(node, cur);
        
        for(Node n : node.neighbors){
            dfs(n);
            cur.neighbors.add(oldToNew.get(n));
        }
    }
}












