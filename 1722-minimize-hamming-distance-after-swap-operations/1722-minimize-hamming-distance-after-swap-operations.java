class Solution {
    private int[] parent;
    private int[] nodeCount;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int size = source.length;
        initialize(size);

        for (int[] swap : allowedSwaps) {
            int u = swap[0];
            int v = swap[1];

            union(u, v);
        }

        Map<Integer, Map<Integer, Integer>> parentMaps = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int pi = findParent(i);

            Map<Integer, Integer> parentMap = parentMaps.getOrDefault(pi, new HashMap<>());

            int count = parentMap.getOrDefault(source[i], 0);
            parentMap.put(source[i], count + 1);
            parentMaps.put(pi, parentMap);
        }

        int ans = 0;
        for (int i = 0; i < size; i++) {
            int pi = findParent(i);

            Map<Integer, Integer> parentMap = parentMaps.get(pi);

            int count = parentMap.getOrDefault(target[i], 0);

            if (count > 0) {
                parentMap.put(target[i], count - 1);
            } else {
                ans += 1;
            }
            
            parentMaps.put(pi, parentMap);
        }

        return ans;
    }

    private void initialize(int size) {
        parent = new int[size];
        nodeCount = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            nodeCount[i] = 1;
        }
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        } 

        parent[node] = findParent(parent[parent[node]]);
        return parent[node];
    }

    private void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) {
            return;
        }

        if (nodeCount[pu] <= nodeCount[pv]) {
            parent[pu] = pv;
            nodeCount[pv] += nodeCount[pu];
        } else {
            parent[pv] = pu;
            nodeCount[pu] += nodeCount[pv];
        }
    }
}