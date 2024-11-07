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
    public boolean isBalanced(TreeNode root) {
        Pair temp = isHeightBalanced(root);
        return temp.isHB;
    }

    private Pair isHeightBalanced(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair left = isHeightBalanced(root.left);
        Pair right = isHeightBalanced(root.right);

        if (Math.abs(left.height - right.height) <= 1 && left.isHB && right.isHB) {
            return new Pair(Math.max(left.height, right.height) + 1, true);
        }

        return new Pair(Math.max(left.height, right.height) + 1, false);
    }

    class Pair {
        int height;
        boolean isHB;

        public Pair(int _height, boolean _isHB) {
            height = _height;
            isHB = _isHB;
        }
    }
}