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
    public List<List<Integer>> findLeaves(TreeNode root) {
        int depth = getDepth(root);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            result.add(new ArrayList<>());
        }

        generateResult(root, result);
        
        return result;
    }

    private int generateResult(TreeNode root,  List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }

        int leftDepth = generateResult(root.left, result);
        int rightDepth = generateResult(root.right, result);

        int currDepth = 1 + Math.max(leftDepth, rightDepth);
        result.get(currDepth - 1).add(root.val);

        return currDepth;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}