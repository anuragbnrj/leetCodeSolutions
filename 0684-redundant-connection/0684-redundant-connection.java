class Solution {

    int[] parent;
    int[] size;

    private int findParent(int node) {
        if (parent[node] == node) return node;

        return parent[node] = findParent(parent[node]);
    }

    private void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) {
            return;
        }

        if (size[pu] <= size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    } 

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        parent = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            parent[i] = i;
        }
        size = new int[len + 1];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (findParent(u) == findParent(v)) {
                return new int[]{u, v};
            } else {
                unionBySize(u, v);
            }
        }

        return new int[]{-1, -1};
    }
}