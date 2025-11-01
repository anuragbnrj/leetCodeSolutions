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
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }

        ListNode temp = new ListNode();
        temp.next = head;
        
        ListNode prev = temp;
        ListNode curr = temp.next;

        while (curr != null) {
            if (present.contains(curr.val)) {
                curr = curr.next;
                prev.next = curr;
            } else {
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            }
        }

        return temp.next;
    }
}