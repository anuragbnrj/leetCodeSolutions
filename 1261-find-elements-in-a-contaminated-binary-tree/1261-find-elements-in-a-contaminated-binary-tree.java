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
class FindElements {

    private Set<Integer> present;

    public FindElements(TreeNode root) {
        present = new HashSet<>();

        generateTree(root, 0);
    }

    private void generateTree(TreeNode root, int val) {
        if (root == null) return;

        root.val = val;
        present.add(val);

        generateTree(root.left, 2 * val + 1);
        generateTree(root.right, 2 * val + 2);
    }
    
    public boolean find(int target) {
        if (present.contains(target)) {
            return true;
        }

        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */