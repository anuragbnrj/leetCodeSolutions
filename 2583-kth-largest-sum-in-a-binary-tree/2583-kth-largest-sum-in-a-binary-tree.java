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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            long levelSum = 0;

            for (int i = 0; i < len; i++) {
                TreeNode front = q.poll();

                levelSum += front.val;

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            pq.add(levelSum);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        if (pq.size() < k) {
            return -1;
        }

        return pq.peek();
        
    }
}