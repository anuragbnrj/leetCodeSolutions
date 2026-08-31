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
    int INF = (int) 1e9;

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {INF, 0};
        
        int dist = 1;
        int firstCritical = 0;
        int prevCritical = 0;

        for (ListNode curr = head.next, prev = head; curr.next != null; curr = curr.next, prev = prev.next, dist += 1) {
            if ((prev.val < curr.val && curr.val > curr.next.val) || (prev.val > curr.val && curr.val < curr.next.val)) {
                if (firstCritical == 0) {
                    firstCritical = dist;
                    prevCritical = dist;
                } else {
                    ans[0] = Math.min(ans[0], dist - prevCritical);
                    ans[1] = Math.max(ans[1], dist - firstCritical);

                    prevCritical = dist;
                }
            }
        }

        if (ans[1] == 0) {
            return new int[]{-1, -1};
        }

        return ans;
    }
}