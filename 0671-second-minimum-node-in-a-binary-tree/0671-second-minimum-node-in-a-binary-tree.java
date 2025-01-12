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

    long min = Long.MAX_VALUE;
    long secondMin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);

        return (secondMin == Long.MAX_VALUE) ? -1 : (int) secondMin;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);

        if (root.val < min) {
            secondMin = min;
            min = root.val;
        } else if (root.val < secondMin && root.val > min) {
            secondMin = root.val;
        }

        return;
    }
}