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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        TreeNode left1 = root1.left;
        TreeNode right1 = root1.right;

        TreeNode left2 = root2.left;
        TreeNode right2 = root2.right;

        boolean ansLeft = false;
        ansLeft = ansLeft || flipEquiv(left1, left2);
        ansLeft = ansLeft || flipEquiv(left1, right2);

        boolean ansRight = false;
        ansRight = ansRight || flipEquiv(right1, right2);
        ansRight = ansRight || flipEquiv(right1, left2);

        return (ansLeft && ansRight);
    }
}