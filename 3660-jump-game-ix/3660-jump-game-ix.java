class Solution {
    private int[] parent;
    private int[] rank;

    public int[] maxValue(int[] nums) {
        int size = nums.length;
        initialize(nums);

        int[] prefixMax = new int[size];
        prefixMax[0] = nums[0];
        for(int i = 1; i < size; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        int[] suffixMin = new int[size];
        suffixMin[size - 1] = nums[size - 1];
        for(int i = size - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        for(int i = 0; i < size - 1; i++) {
            if(prefixMax[i] > suffixMin[i + 1]) {
                union(i, i + 1);
            }
        }

        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            int pi = getParent(i);
            ans[i] = rank[pi];
        }

        return ans;
    }

    private void initialize(int[] nums) {
        int size = nums.length;
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = nums[i];
        }
    }

    private int getParent(int i) {
        if (parent[i] == i)
            return i;

        parent[i] = getParent(parent[i]);
        return parent[i];
    }

    private void union(int u, int v) {
        int pu = getParent(u);
        int pv = getParent(v);

        if (pv == pu) return;

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;

        } else {
            parent[pu] = pv;
        }
    }
}