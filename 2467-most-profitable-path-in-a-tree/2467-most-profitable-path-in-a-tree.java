class Solution {
    private List<Integer> bobPath;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int nodes = amount.length;

        // Build adjacency list
        ArrayList<Integer>[] adjList = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // Find Bob's path from his starting node to the root (node 0)
        dfs(bob, 0, new ArrayList<>(), adjList, -1);
        // System.out.println(bobPath.toString()); // Debugging line, can be removed

        // Initialize Bob's arrival times
        int[] bobReachedAt = new int[nodes];
        Arrays.fill(bobReachedAt, Integer.MAX_VALUE);
        for (int i = 0; i < bobPath.size(); i++) {
            int curr = bobPath.get(i);
            bobReachedAt[curr] = i; // Time when Bob reaches this node
        }

        // Compute Alice's maximum score starting from node 0 at time 0
        int ans = dfsAlice(0, -1, 0, amount, bobReachedAt, adjList);
        return ans;
    }

    // DFS to find Bob's path from curr to des (node 0)
    private boolean dfs(int curr, int des, List<Integer> currPath, ArrayList<Integer>[] adjList, int parent) {
        if (curr == des) {
            currPath.add(curr);
            bobPath = new ArrayList<>(currPath);
            return true;
        }
        currPath.add(curr);
        for (int neigh : adjList[curr]) {
            if (neigh == parent) continue;
            boolean res = dfs(neigh, des, currPath, adjList, curr);
            if (res) {
                return true;
            }
        }
        currPath.remove(currPath.size() - 1);
        return false;
    }

    // DFS to compute Alice's maximum score from node u to a leaf
    private int dfsAlice(int u, int parent, int time, int[] amount, int[] bobReachedAt, ArrayList<Integer>[] adjList) {
        // Calculate contribution at current node
        int contribution;
        if (time < bobReachedAt[u]) {
            contribution = amount[u]; // Alice arrives before Bob
        } else if (time == bobReachedAt[u]) {
            contribution = amount[u] / 2; // Alice and Bob arrive simultaneously (integer division)
        } else {
            contribution = 0; // Bob arrives before Alice
        }

        // Find maximum score from children
        int maxChildScore = Integer.MIN_VALUE;
        for (int v : adjList[u]) {
            if (v != parent) {
                int childScore = dfsAlice(v, u, time + 1, amount, bobReachedAt, adjList);
                maxChildScore = Math.max(maxChildScore, childScore);
            }
        }

        // If no children (leaf node), return contribution
        if (maxChildScore == Integer.MIN_VALUE) {
            return contribution;
        }
        // Otherwise, return contribution plus best child score
        return contribution + maxChildScore;
    }
}