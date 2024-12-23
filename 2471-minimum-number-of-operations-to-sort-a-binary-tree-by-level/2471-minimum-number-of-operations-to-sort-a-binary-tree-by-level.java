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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int swaps = 0;
        while (q.size() > 0) {
            int sz = q.size();

            List<Integer> list = new ArrayList<>();
            TreeMap<Integer, Integer> tmap = new TreeMap<>();
            for (int i = 0; i < sz; i++) {
                TreeNode front = q.poll();
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);

                tmap.put(front.val, i);
                list.add(front.val);    
            }

            int reqdIdx = 0;
            for (Map.Entry<Integer, Integer> entry : tmap.entrySet()) {
                int val = entry.getKey();
                int currIdx = entry.getValue();

                if (currIdx != reqdIdx) {
                    int otherVal = list.get(reqdIdx);

                    // System.out.println("val: " + val + ", currIdx: " + currIdx + ", otherVal: " + otherVal + ", reqdIdx: " + reqdIdx);

                    list.set(reqdIdx, val);
                    list.set(currIdx, otherVal);
                    tmap.put(otherVal, currIdx);
                    swaps += 1; 
                }

                reqdIdx += 1;
            }
        }

        return swaps;
    }
}