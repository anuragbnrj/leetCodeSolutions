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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = (int) -1e9;

        calculateMaxPath(root);

        return ans;
    }


    private int calculateMaxPath(TreeNode root) {
        if (root == null) {
            return (int) -1e9;
        }

        int left = calculateMaxPath(root.left);
        int right = calculateMaxPath(root.right);
        int mx = Math.max(left, right);

        ans = Math.max(ans, root.val + Math.max(0, left) + Math.max(0, right));

        return (root.val + Math.max(0, mx));
    }
}