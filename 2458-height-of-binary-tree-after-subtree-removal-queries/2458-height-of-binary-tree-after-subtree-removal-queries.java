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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int sz = (int) 1e5 + 1;
        int[] subTreeDepth = new int[sz];
        int[] excludingDepth = new int[sz];

        calculateSubTreeDepth(root, subTreeDepth);
        precompute(root, 0, 0, excludingDepth, subTreeDepth);

        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = excludingDepth[queries[i]];
        }

        return ans;
    }

    private void precompute(TreeNode root, int currDepth, int otherMax, int[] excludingDepth, int[] subTreeDepth) {
        if (root == null) {
            return;
        }

        excludingDepth[root.val] = Math.max(currDepth - 1, otherMax);

        int leftDepth = root.left == null ? 0 : subTreeDepth[root.left.val] + 1;
        int rightDepth = root.right == null ? 0 : subTreeDepth[root.right.val] + 1;

        precompute(root.left, currDepth + 1, Math.max(otherMax, currDepth + rightDepth), excludingDepth, subTreeDepth);
        precompute(root.right, currDepth + 1, Math.max(otherMax, currDepth + leftDepth), excludingDepth, subTreeDepth);
    }

    private int calculateSubTreeDepth(TreeNode root, int[] subTreeDepth) {
        if (root == null) {
            return -1;
        }

        int leftDepth = calculateSubTreeDepth(root.left, subTreeDepth);
        int rightDepth = calculateSubTreeDepth(root.right, subTreeDepth);

        subTreeDepth[root.val] = 1 + Math.max(leftDepth, rightDepth);

        return subTreeDepth[root.val];
    }
}