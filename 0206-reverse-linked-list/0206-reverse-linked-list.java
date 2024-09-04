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
    ListNode h;
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        reverse(head);
        head = h;
        return head;
    }

    private void reverse(ListNode curr) {
        if (curr.next == null) {
            h = curr;
            return;
        }

        reverse(curr.next);

        curr.next.next = curr;
        curr.next = null;
    }
}