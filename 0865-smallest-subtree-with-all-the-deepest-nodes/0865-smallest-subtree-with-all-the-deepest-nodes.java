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
    private TreeNode ans;
    private int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans = null;
        maxDepth = 0;

        calculateMaxDepthSubtree(root, 0);

        return ans; 
    }

    private int calculateMaxDepthSubtree(TreeNode curr, int depth) {
        int leftDepth = 0;
        if (curr.left != null) leftDepth = calculateMaxDepthSubtree(curr.left, depth + 1);

        int rightDepth = 0;
        if (curr.right != null) rightDepth = calculateMaxDepthSubtree(curr.right, depth + 1);

        if (leftDepth == rightDepth && leftDepth == maxDepth) {
            ans = curr;
        }

        int currMaxDepth = Math.max(depth, Math.max(leftDepth, rightDepth));
        if (currMaxDepth > maxDepth) {
            ans = curr;
            maxDepth = currMaxDepth;
        }

        return currMaxDepth;
    }
}