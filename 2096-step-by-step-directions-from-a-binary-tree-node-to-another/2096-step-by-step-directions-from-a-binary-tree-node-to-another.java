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
    static StringBuilder ans;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ans = new StringBuilder();

        Map<Integer, int[]> neighbours = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode front = q.poll();
            int[] frontNeighbours = neighbours.getOrDefault(front.val, new int[3]);

            TreeNode left = front.left;
            if (left != null) {
                int[] leftNeighbours = neighbours.getOrDefault(left.val, new int[3]);
                leftNeighbours[0] = front.val;
                frontNeighbours[1] = left.val;
                q.add(left);
                neighbours.put(left.val, leftNeighbours);
            }

            TreeNode right = front.right;
            if (right != null) {
                int[] rightNeighbours = neighbours.getOrDefault(right.val, new int[3]);
                rightNeighbours[0] = front.val;
                frontNeighbours[2] = right.val;
                q.add(right);
                neighbours.put(right.val, rightNeighbours);
            }

            neighbours.put(front.val, frontNeighbours);
        }

        StringBuilder temp = new StringBuilder();
        boolean[] visited = new boolean[100005];
        dfs(startValue, destValue, neighbours, temp, visited);

        return ans.toString();
    }

    private static void dfs(int curr, int des, Map<Integer, int[]> neighbours, StringBuilder temp, boolean[] visited) {
        visited[curr] = true;

        if (curr == des) {
            ans = new StringBuilder(temp);
            return;
        }
        
        // System.out.println("curr: " + curr);
        int[] next = neighbours.get(curr);
        if (next[0] != 0 && ans.length() == 0 && visited[next[0]] == false) {
            temp.append('U');
            dfs(next[0], des, neighbours, temp, visited);
            temp.setLength(temp.length() - 1);
        }

        if (next[1] != 0 && ans.length() == 0 && visited[next[1]] == false) {
            temp.append('L');
            dfs(next[1], des, neighbours, temp, visited);
            temp.setLength(temp.length() - 1);
        }

        if (next[2] != 0 && ans.length() == 0 && visited[next[2]] == false) {
            temp.append('R');
            dfs(next[2], des, neighbours, temp, visited);
            temp.setLength(temp.length() - 1);
        }
    }
}