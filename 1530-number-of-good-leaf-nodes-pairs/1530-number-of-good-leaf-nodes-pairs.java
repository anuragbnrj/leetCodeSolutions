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

    ArrayList<Integer> leafNodes;
    ArrayList<Integer>[] graph;

    public int countPairs(TreeNode root, int distance) {
        graph = new ArrayList[1003];
        for (int i = 0; i < 1003; i++) {
            graph[i] = new ArrayList<>();
        }

        leafNodes = new ArrayList<>();
        dfs(root, null);

        int ans = 0;
        for (int i = 0; i < leafNodes.size(); i++) {
            for (int j = i + 1; j < leafNodes.size(); j++) {
                int src = leafNodes.get(i);
                int des = leafNodes.get(j);
                int shortestPathLen = getShortestPathLen(src, des);

                if (shortestPathLen <= distance) {
                    // System.out.println("src: " + src + ", des: " + des + ", shortestPathLen: " + shortestPathLen);
                    ans += 1;
                } 
            }
        }
        
        return ans;
    }

    private int getShortestPathLen(int src, int des) {
        boolean[] visited = new boolean[1003];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        int dist = 1;
        while (q.size() > 0) {
            int layerSize = q.size();
            for (int i = 0; i < layerSize; i++) {
                int front = q.peek();
                q.poll();
                for (int neigh : graph[front]) {
                    if (neigh == des) {
                        return dist;
                    }

                    if (visited[neigh] == false) {
                        q.add(neigh);
                        visited[neigh] = true;
                    }
                }
            }

            dist += 1;
        }

        return dist;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (parent != null) {
            graph[parent.val].add(root.val);
            graph[root.val].add(parent.val);
        }

        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
        }

        dfs(root.left, root);
        dfs(root.right, root);
    }
}