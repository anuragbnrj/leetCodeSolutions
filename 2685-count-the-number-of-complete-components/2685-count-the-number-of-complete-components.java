class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int[] size = new int[n];
        int[] edgesCount = new int[n];

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, size, edgesCount, i);

                if ((size[i] * (size[i] - 1)) == edgesCount[i]) {
                    ans += 1;
                }
            }
        }

        return ans;
    }

    private void dfs(int curr, List<Integer>[] adjList, boolean[] visited, int[] size, int[] edgesCount, int parent) {
        visited[curr] = true;
        size[parent] += 1;

        for (int neigh : adjList[curr]) {
            if (neigh != curr) {
                edgesCount[parent] += 1;
            }

            if (!visited[neigh]) {
                dfs(neigh, adjList, visited, size, edgesCount, parent);
            }
        }
    }
}