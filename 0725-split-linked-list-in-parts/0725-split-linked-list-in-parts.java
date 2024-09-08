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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getSize(head);
        int rem = len % k;

        ListNode curr = head;

        ListNode[] ans = new ListNode[k];
        int idx = 0;
        while (curr != null) {
            int requiredNodes = len / k;

            ListNode dummyNode = new ListNode();
            ListNode prev = dummyNode;
            while (requiredNodes > 0 && curr != null) {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
                requiredNodes -= 1;
            }

            if (rem > 0) {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
                rem -= 1;
            }

            prev.next = null;
            ans[idx] = dummyNode.next;
            idx += 1;
        }

        return ans;
    }

    private int getSize(ListNode head) {
        ListNode curr = head;
        int size = 0;

        while (curr != null) {
            size += 1;

            curr = curr.next;
        }

        return size;
    }
}