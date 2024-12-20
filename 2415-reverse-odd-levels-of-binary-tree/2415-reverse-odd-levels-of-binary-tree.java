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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while (q.size() > 0) {
            List<TreeNode> levelNodes = new ArrayList<>();
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode front = q.poll();
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);

                levelNodes.add(front);
            }

            if(level % 2 == 1) {
                for (int left = 0, right = levelNodes.size() - 1; left < right; left++, right--) {
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp; 
                }
            }

            level += 1;
        }

        return root;
    }
}