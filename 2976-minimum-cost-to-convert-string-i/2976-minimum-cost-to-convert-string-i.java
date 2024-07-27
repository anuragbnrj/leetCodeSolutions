class Solution {
    int INF = 1_000_000_000;
    long INFL = (long)1e18;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = INFL;
                }
            }
        }

        int l = original.length;
        for (int i = 0; i < l; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int wt = cost[i];

            dist[u][v] = Math.min(dist[u][v], wt); 
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if (dist[u][v] == INFL) {
                return -1;
            }

            ans += dist[u][v];
        }

        return ans;
    }
}