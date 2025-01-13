/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = null, right = null;
        if (root.left != null){
            left = lowestCommonAncestor(root.left, p, q);
        } 
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        if (left != null && right != null) {
            return root;
        } 

        if (left == null) {
            return right;
        }
        return left;
    }
}