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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                prev.next = ptr1;
                prev = prev.next;
                ptr1 = ptr1.next;
            } else {
                prev.next = ptr2;
                prev = prev.next;
                ptr2 = ptr2.next;
            }
        }

        while (ptr1 != null) {
            prev.next = ptr1;
            prev = prev.next;
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            prev.next = ptr2;
            prev = prev.next;
            ptr2 = ptr2.next;
        }

        return dummy.next;
    }
}