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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans = solve(head, root, false);

        return ans;
    }

    private boolean solve(ListNode head, TreeNode root, boolean started) {
        if (head == null) {
            return true;
        }

        if (root == null && head != null) {
            return false;
        }

        boolean ans = false;
        if (started) {
            if (head.val != root.val) {
                return false;
            }

            ans = ans || solve(head.next, root.left, started);
            ans = ans || solve(head.next, root.right, started);

            ans = ans || solve(head, root.left, false);
            ans = ans || solve(head, root.right, false);

            return ans;
        } else {
            if (head.val != root.val) {
                ans = ans || solve(head, root.left, started);
                ans = ans || solve(head, root.right, started);
            } else {
                ans = ans || solve(head.next, root.left, true);
                ans = ans || solve(head.next, root.right, true);
            }

            return ans;
        }
    }
}