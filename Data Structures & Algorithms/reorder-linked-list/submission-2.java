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

        ListNode temp = head.next;
        int turn = 1;

        while(head != null){
            System.out.println(turn);
            if(turn == 1){
                head.next = head_half;
                if(head_half != null) head_half = head_half.next;
            }else{
                head.next = temp;
                if(temp != null) temp = temp.next;
            }
            head = head.next;
            turn = -turn;
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
