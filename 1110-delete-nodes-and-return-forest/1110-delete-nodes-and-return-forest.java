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
    Map<TreeNode, Boolean> visited;
    Queue<TreeNode> dfsOrder;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        dfsOrder = new LinkedList<>();
        visited = new HashMap<>();
        dfs(root);

        Set<Integer> delete = IntStream.of(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> ans = new ArrayList<>();
        while (dfsOrder.size() > 0) {
            TreeNode node = dfsOrder.peek();
            dfsOrder.poll();

            if (visited.get(node).equals(false) && !delete.contains(node.val)) {
                ans.add(node);
                markForest(node, delete);
            }
        }

        return ans;
    }

    private void markForest(TreeNode node, Set<Integer> delete) {
        if (node == null || delete.contains(node.val)) {
            return;
        }

        visited.put(node, true);

        if (node.left != null) {
            if (delete.contains(node.left.val)) {
                node.left = null;
            } else {
                markForest(node.left, delete);
            }
        }

        if (node.right != null) {
            if (delete.contains(node.right.val)) {
                node.right = null;
            } else {
                markForest(node.right, delete);
            }
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsOrder.add(root);
        visited.put(root, false);

        dfs(root.left);
        dfs(root.right);
    }
}