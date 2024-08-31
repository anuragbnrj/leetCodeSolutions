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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode ans = solveAddOneRow(root, val, depth, 1);
        return ans;
    }

    private TreeNode solveAddOneRow(TreeNode root, int val, int depth, int currDepth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        if (root == null) {
            return null;
        }

        if (currDepth == (depth - 1)) {
            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;

            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            return root;
        }

        solveAddOneRow(root.left, val, depth, currDepth + 1);
        solveAddOneRow(root.right, val, depth, currDepth + 1);
        return root;
    }

}