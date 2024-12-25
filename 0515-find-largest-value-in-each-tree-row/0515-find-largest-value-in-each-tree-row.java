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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        List<Integer> ans = new ArrayList<>();
        while (q.size() > 0) {
            int sz = q.size();

            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode front = q.poll();

                rowMax = Math.max(rowMax, front.val);

                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }

            ans.add(rowMax);
        }

        return ans;
    }
}
