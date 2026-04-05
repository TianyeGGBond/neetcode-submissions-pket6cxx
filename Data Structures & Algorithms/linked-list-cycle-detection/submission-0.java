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
    public boolean hasCycle(ListNode head) {
        if(head == null) return true;
        ListNode f = head;
        ListNode s = head;
        while(f != null && s != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s) return true;
        }
        return false;

    }
}
