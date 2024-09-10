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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;

        while (curr.next != null) {
            int a = curr.val;
            int b = curr.next.val;

            int gcd = getGcd(a, b);

            ListNode gcdNode = new ListNode(gcd);
            ListNode next = curr.next;
            curr.next = gcdNode;
            gcdNode.next = next;
            curr = next;
        }

        return head;
    }

    private int getGcd(int a, int b) {
        int tmp = 0;
        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        
        return a;
    }
}