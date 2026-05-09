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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //even h/2, odd h+1/2
        ListNode head_half = reverse(slow.next);
        slow.next = null;

        while(head != null && head_half != null){
            ListNode temp1 = head.next;
            ListNode temp2 = head_half.next;
            head.next = head_half;
            head_half.next = temp1;
            head = head.next;
            head_half = head_half.next;
            head.next = temp2;
        }
        
    }
    private ListNode reverse(ListNode ls){
        ListNode prev = null, cur = ls;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            
        }
        return prev;
    }
}
