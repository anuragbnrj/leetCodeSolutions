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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode newRoot = findRoot(root);

        rearrangeTree(root); 

        return newRoot;   
    }

    private void rearrangeTree(TreeNode root) {
        if (root == null || root.left == null) return;

        rearrangeTree(root.left);

        // System.out.println("root: " + root.val + ", root.right: " + root.right.val + ", root.left: " + root.left.val);

        root.left.left = root.right;
        root.left.right = root;

        // System.out.println("root: " + root.val + ", root.right: " + root.right.val + ", root.left: " + root.left.val);

        root.left = null;
        root.right = null;
    }

    private TreeNode findRoot(TreeNode root) {
        if (root == null || root.left == null) return root;

        return findRoot(root.left); 
    }
}