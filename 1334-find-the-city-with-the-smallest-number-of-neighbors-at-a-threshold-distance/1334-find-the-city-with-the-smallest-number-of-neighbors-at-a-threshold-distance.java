class Solution {
    int INF = 1_000_000_000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = Math.min(dist[u][v], wt);
            dist[v][u] = Math.min(dist[v][u], wt);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minReach = INF;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int currReach = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    currReach += 1;
                }
            }

            if (currReach <= minReach) {
                minReach = currReach;
                ans = i;
            }
        }

        return ans;
    }
}