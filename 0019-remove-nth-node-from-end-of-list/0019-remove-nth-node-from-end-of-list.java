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
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode tail = dummy;
        
        for (int i = 1; i <= n; i++) {
            curr = curr.next;
        }

        while (curr != null) {
            curr = curr.next;
            tail = tail.next;
        }

        tail.next = tail.next.next;
        return dummy.next;
    }
}