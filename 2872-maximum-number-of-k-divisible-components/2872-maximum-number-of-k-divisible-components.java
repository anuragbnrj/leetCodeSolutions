class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int[] components = new int[1];
        dfs(0, adjList, values, visited, components, k);
        return components[0];
    }

    private int dfs(int curr, List<Integer>[] adjList, int[] values, boolean[] visited, int[] components, int k) {
        visited[curr] = true;

        int currComponentSum = values[curr];

        List<Integer> neighbours = adjList[curr];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                currComponentSum += dfs(neighbour, adjList, values, visited, components, k);
            }
        }

        if (currComponentSum % k == 0) {
            components[0] += 1;
            return 0;
        }

        return currComponentSum;
    }
}