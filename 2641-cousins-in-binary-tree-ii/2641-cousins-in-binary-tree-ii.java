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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<QueueElement> q = new LinkedList<>();
        q.add(new QueueElement(root, root.val));

        while (!q.isEmpty()) {
            int sz = q.size();

            int levelSum = 0;
            for (int i = 0; i < sz; i++) {
                QueueElement front = q.poll();
                levelSum += front.node.val;
                q.add(front);
            }

            for (int i = 0; i < sz; i++) {
                QueueElement front = q.poll();
                front.node.val = levelSum - front.ownSum;

                int ownChildSum  = 0;
                if (front.node.left != null) {
                    ownChildSum += front.node.left.val;
                }
                if (front.node.right != null) {
                    ownChildSum += front.node.right.val;
                }

                if (front.node.left != null) {
                    q.add(new QueueElement(front.node.left, ownChildSum));
                }
                if (front.node.right != null) {
                    q.add(new QueueElement(front.node.right, ownChildSum));
                }
            }
        }

        return root;
    }

    class QueueElement {
        TreeNode node;
        int ownSum;

        public QueueElement(TreeNode _node, int _ownSum) {
            node = _node;
            ownSum = _ownSum;
        }
    }
}