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

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        // Step 1: Find the lowest common ancestor of nodes p and q
        TreeNode ans = LCA(root, p, q);

        // Step 2: Check if the LCA is p, meaning q must be in p's subtree
        if (ans == p) {
            // Verify if q is in the subtree of p
            return dfs(p, q) ? p : null;
        }
        // Step 3: Check if the LCA is q, meaning p must be in q's subtree
        else if (ans == q) {
            // Verify if p is in the subtree of q
            return dfs(q, p) ? q : null;
        }

        // Step 4: If neither p nor q is the ancestor of the other, return the LCA
        return ans;
    }

    private TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
        // Base case: if the current node is null, p, or q, return the current node
        if (node == null || node == p || node == q) return node;

        // Recursive case: find LCA in left and right subtrees
        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);

        // If p and q are found in different subtrees, current node is their LCA
        if (left != null && right != null) return node;
        // Otherwise, return the non-null result (either left or right)
        else if (left != null) return left;
        else return right;
    }

    private boolean dfs(TreeNode node, TreeNode target) {
        // Base case: target found
        if (node == target) return true;

        // Base case: reached null, target not found
        if (node == null) return false;

        // Recursive case: search target in left or right subtree
        return dfs(node.left, target) || dfs(node.right, target);
    }
}