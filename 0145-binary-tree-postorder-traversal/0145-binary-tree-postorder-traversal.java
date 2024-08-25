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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solvePostOrder(root, ans);

        return ans;   
    }

    private void solvePostOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        solvePostOrder(root.left, ans);
        solvePostOrder(root.right, ans);

        ans.add(root.val);
    }
}