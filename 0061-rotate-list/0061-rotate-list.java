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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        int len = getLength(head);
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode headA = head, tailA = null, headB = null, tailB = null;
        int ctr = 1;
        while (curr != null) {
            if (ctr == (len - k + 1)) {
                tailA = prev;
                headB = curr;
            }

            prev = curr;
            curr = curr.next;
            tailB = prev;
            ctr += 1;
        }


        head = headB;
        if (tailB != null) {
            tailB.next = headA;
        }
        if (tailA != null) {
            tailA.next = null;
        }
        
        return head;
    }

    private int getLength(ListNode head) {
        int len = 0;

        ListNode temp = head;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }

        return len;
    }
}