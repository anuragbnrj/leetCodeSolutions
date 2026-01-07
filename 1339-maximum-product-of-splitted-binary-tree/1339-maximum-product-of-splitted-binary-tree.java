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
    private final int MOD = (int) 1e9 + 7;
    private long maximumPrdOfSum;

    public int maxProduct(TreeNode root) {
        long totalSum = 0;
        maximumPrdOfSum = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode front = q.poll();
                totalSum += front.val;

                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
        }
        maximizePrdOfSum(root, totalSum);

        return (int) (maximumPrdOfSum % MOD);
    }

    private long maximizePrdOfSum(TreeNode curr, long totalSum) {
        long leftSum = 0;
        if (curr.left != null) leftSum = maximizePrdOfSum(curr.left, totalSum);

        long rightSum = 0;
        if (curr.right != null) rightSum = maximizePrdOfSum(curr.right, totalSum);

        maximumPrdOfSum = Math.max(maximumPrdOfSum, (totalSum - leftSum) * leftSum);
        maximumPrdOfSum = Math.max(maximumPrdOfSum, (totalSum - rightSum) * rightSum);

        return (0L + leftSum + curr.val + rightSum);
    }
}