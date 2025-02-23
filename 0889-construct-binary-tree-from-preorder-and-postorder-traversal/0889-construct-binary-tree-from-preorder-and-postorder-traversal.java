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
    Map<Integer, Integer> pos;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        pos = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            pos.put(postorder[i], i);
        }

        return generateTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode generateTree(int[] preorder, int prebeg, int preend, int[] postorder, int postbeg, int postend) {
        if ((preend - prebeg + 1) == 1) {
            TreeNode node = new TreeNode(preorder[prebeg]);

            return node;
        }

        if (preend < prebeg) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[prebeg]);
        int leftVal = preorder[prebeg + 1];
        int leftValPos = pos.get(leftVal);
        node.left = generateTree(preorder, prebeg + 1, prebeg + 1 + (leftValPos - postbeg), postorder, postbeg, leftValPos);

        node.right = generateTree(preorder, prebeg + 1 + (leftValPos - postbeg) + 1, preend, postorder, leftValPos + 1, postend - 1);

        return node;
    }
}