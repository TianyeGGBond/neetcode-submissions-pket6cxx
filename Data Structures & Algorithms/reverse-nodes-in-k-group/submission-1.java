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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode oldhead = pre.next;

        while(true){
            ListNode kth = getk(oldhead, k);
            if(kth == null) break;
            ListNode nexthead = kth.next;

            ListNode cur = oldhead;
            ListNode prev = nexthead;
            while(cur != nexthead){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            pre.next = kth;
            pre = oldhead;
            oldhead = nexthead;
        }
        return dummy.next;
    }

    private ListNode getk(ListNode node, int k){
        if(node == null) return null;
        for(int i = 0; i < k-1; i++){
            if(node == null) return null;
            node = node.next;
        }
        return node;
    }
}
