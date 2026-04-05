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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode slow = head;
        for(int i = 0; i < n-1; i++){
            slow = slow.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        while(slow != null && slow.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = fast.next.next;
        return  dummy.next;
    }
}
