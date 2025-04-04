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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return getLCA(root).getKey();
    }

    private Pair<TreeNode, Integer> getLCA(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }

        Pair<TreeNode, Integer> leftLCA = getLCA(root.left);
        Pair<TreeNode, Integer> rightLCA = getLCA(root.right);

        if (leftLCA.getValue() > rightLCA.getValue()) {
            return new Pair<>(leftLCA.getKey(), leftLCA.getValue() + 1);
        } else if (leftLCA.getValue() < rightLCA.getValue()) {
            return new Pair<>(rightLCA.getKey(), rightLCA.getValue() + 1);
        } else {
            return new Pair<>(root, leftLCA.getValue() + 1);
        }
    }
}