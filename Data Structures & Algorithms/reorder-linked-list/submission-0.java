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
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);

        ListNode cur = head;
        while(cur != null && head != null && head2 != null){
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;


            cur.next = head2;
            cur = cur.next;
            head2 = temp2;

            cur.next = temp1;
            head = temp1;
            cur = cur.next;
        }
        return;

    }
    private ListNode reverse(ListNode x){
        if(x == null || x.next == null) return x;
        ListNode pre = null;
        ListNode cur = x;
        while(cur!= null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
