class Solution {
    public int minimumCost(int[] cost) {
        int size = cost.length;
        Arrays.sort(cost);

        int i = 0;
        int ans = 0;
        for (i = 0; i < size; i++) {
            int curr = cost[size - 1 - i];

            if (i % 3 != 2) {
                ans += curr;
            }
        }

        return ans;
    }
}