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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add_on = 0;
        int remain = 0;

        ListNode res = new ListNode(0);
        ListNode dummy = res;

        while(l1 != null && l2 != null){
            remain = (l1.val + l2.val + add_on) % 10;
            add_on = (l1.val + l2.val + add_on) / 10;
            res.next = new ListNode(remain);

            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            remain = (l1.val + add_on) % 10;
            add_on = (l1.val + add_on) / 10;
            res.next = new ListNode(remain);
            res = res.next;
            l1 = l1.next;
        }
        while(l2 != null){
            remain = (l2.val + add_on) % 10;
            add_on = (l2.val + add_on) / 10;
            res.next = new ListNode(remain);
            res = res.next;
            l2 = l2.next;
        }
        if(add_on != 0){
            res.next = new ListNode(add_on);
        }
        return dummy.next;
    }
}
