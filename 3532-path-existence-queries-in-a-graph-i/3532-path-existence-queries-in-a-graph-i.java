class Solution {
    private int[] parent;
    private int[] weight;

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int curr = i;
            int prev = i - 1;

            if (nums[curr] - nums[prev] <= maxDiff) {
                union(curr, prev);
            }
        }

        int m = queries.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int parU = getParent(u);
            int parV = getParent(v);

            if (parU == parV) {
                ans[i] = true;
            }
        }

        return ans;
    }

    private int getParent(int node) {
        if (parent[node] != node) {
            parent[node] = getParent(parent[node]);
        }

        return parent[node];
    }

    private void union(int u, int v) {
        int parU = getParent(u);
        int parV = getParent(v);

        if (parU == parV) return;

        if (weight[parU] < weight[parV]) {
            parent[parU] = parV;
            weight[parV] += weight[parU];
        } else {
            parent[parV] = parU;
            weight[parU] += weight[parV];
        }
    }
}