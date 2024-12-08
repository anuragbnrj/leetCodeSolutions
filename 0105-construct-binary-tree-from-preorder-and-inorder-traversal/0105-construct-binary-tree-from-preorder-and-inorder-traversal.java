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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length, inorder, 0, inorder.length, idxMap);
    }

    private TreeNode build(int[] preorder, int prBeg, int prEnd, int[] inorder, int inBeg, int inEnd, HashMap<Integer, Integer> idxMap) {
        if (prBeg < 0 || prBeg >= preorder.length) return null;
        
        int rootVal = preorder[prBeg];
        TreeNode root = new TreeNode(rootVal);

        if ((prEnd - prBeg + 1) == 1) return root;

        int inorderRootIdx = idxMap.get(rootVal);
        int leftCount = inorderRootIdx - inBeg;
        TreeNode left = null;
        if (leftCount > 0) left = build(preorder, prBeg + 1, prBeg + leftCount, inorder, inBeg, inorderRootIdx - 1, idxMap);
        
        int rightCount = inEnd - inorderRootIdx;
        TreeNode right = null;
        if (rightCount > 0) right = build(preorder, prBeg + leftCount + 1, prEnd, inorder, inorderRootIdx + 1, inEnd, idxMap);

        root.left = left;
        root.right = right;

        return root;
    }
}