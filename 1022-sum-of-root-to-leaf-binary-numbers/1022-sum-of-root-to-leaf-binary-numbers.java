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
    private int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        calculateSum(root, 0);

        return sum;
    }

    private void calculateSum(TreeNode curr, int currNum) {
        currNum = ((currNum << 1) | curr.val);

        if (curr.left == null && curr.right == null) {
            sum += currNum;
            return;
        }

        if (curr.left != null) {
            calculateSum(curr.left, currNum);
        }

        if (curr.right != null) {
            calculateSum(curr.right, currNum);
        }
    }
}