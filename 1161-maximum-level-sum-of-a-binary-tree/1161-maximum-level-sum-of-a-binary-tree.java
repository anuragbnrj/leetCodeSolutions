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
    public int maxLevelSum(TreeNode root) {
        int maximumSum = Integer.MIN_VALUE;
        int maximumSumLevel = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int currLevel = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            currLevel += 1;
            int currLevelSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode front = q.poll();
                currLevelSum += front.val;

                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }

            if (currLevelSum > maximumSum) {
                maximumSum = currLevelSum;
                maximumSumLevel = currLevel;
            }

        }

        return maximumSumLevel;
    }
}