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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        Map<Integer, Pair> nodes = new HashMap<>();
        Set<Integer> isChild = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int val = descriptions[i][0];
            int child = descriptions[i][1];
            isChild.add(child);
            int isLeft = descriptions[i][2];

            Pair temp;
            if (!nodes.containsKey(val)) {
                temp = new Pair();
            } else {
                temp = nodes.get(val);
            }

            if (isLeft == 1) {
                temp.left = child;
            } else {
                temp.right = child;
            }

            nodes.put(val, temp);
        }

        int root = 0;
        for (int i = 0; i < n; i++) {
            int val = descriptions[i][0];

            if (!isChild.contains(val)) {
                root = val;
                break;
            }
        }
        
        TreeNode head = solve(root, nodes);
        return head;
    }

    public static TreeNode solve(int val, Map<Integer, Pair> nodes) {
        if (val == 0) {
            return null;
        }

        if (!nodes.containsKey(val)) {
            return new TreeNode(val, null, null);
        }

        TreeNode curr = new TreeNode(val);
        curr.left = solve(nodes.get(val).left, nodes);
        curr.right = solve(nodes.get(val).right, nodes);

        return curr;
    }

    class Pair {
        int left;
        int right;

        public Pair() {
            this.left = 0;
            this.right = 0;
        }

        public Pair(int l, int r) {
            this.left = l;
            this.right = r;
        }
    }
}
