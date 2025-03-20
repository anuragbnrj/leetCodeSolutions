class Solution {

    private int[] parent;
    private int[] size;
    private int[] bitwiseAND;

    private void initializeDSU(int n) {
        parent = new int[n];
        size = new int[n];
        bitwiseAND = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            bitwiseAND[i] = Integer.MAX_VALUE;
        }
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        parent[node] = findParent(parent[node]);

        return parent[node];
    }

    private void union(int u, int v, int w) {
        int pU = findParent(u);
        int pV = findParent(v);

        if (size[pU] <= size[pV]) {
            parent[pU] = pV;
            size[pV] += size[pU];
            bitwiseAND[pV] = bitwiseAND[pV] & bitwiseAND[pU] & w;
        } else {
            parent[pV] = pU;
            size[pU] += size[pV];
            bitwiseAND[pU] = bitwiseAND[pU] & bitwiseAND[pV] & w;
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        initializeDSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            union(u, v, w);
        }

        int queryLen = query.length;
        int[] ans = new int[queryLen];
        for (int i = 0; i < queryLen; i++) {
            int u = query[i][0];
            int v = query[i][1];

            int pU = findParent(u);
            int pV = findParent(v);

            if (pU == pV) {
                ans[i] = bitwiseAND[pU];
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }


}