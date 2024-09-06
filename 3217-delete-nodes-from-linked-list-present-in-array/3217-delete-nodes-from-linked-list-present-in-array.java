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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> stt = new HashSet<>();
        for (int num : nums) {
            stt.add(num);
        }

        ListNode dummyNode = new ListNode();

        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            if (stt.contains(curr.val)) {
                prev.next = next;
                curr.next = null;
                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummyNode.next;
    }
}