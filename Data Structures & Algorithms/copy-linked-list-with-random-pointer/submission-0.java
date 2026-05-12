/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node cur = head;
        while(cur != null){
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        Node copy = nodeMap.get(cur), out = copy;
        while(cur != null){
            copy.next = nodeMap.get(cur.next);
            copy.random = nodeMap.get(cur.random);

            cur = cur.next;
            copy = copy.next;
        }
        
        return out;
    }
}
