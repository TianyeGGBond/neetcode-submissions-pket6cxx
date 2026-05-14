/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for(ListNode node : lists){
            if(node != null){
                q.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!q.isEmpty()){
            ListNode min_node = q.poll();
            cur.next = min_node;
            cur = cur.next;

            if (min_node.next != null){
                q.offer(min_node.next);
            }
        }

        return dummy.next;
    }
}
