class Solution {
    public long gridGame(int[][] grid) {
        int len = grid[0].length;
        long firstRowSum = 0;
        for (int i = 0; i < len; i++) {
            firstRowSum += grid[0][i];
        }

        long prefixSumTop = 0, prefixSumBottom = 0;
        long ans = (long) 1e15;
        for (int i = 0; i < len; i++) {
            prefixSumTop += grid[0][i];

            ans = Math.min(ans, Math.max((firstRowSum - prefixSumTop), prefixSumBottom));

            prefixSumBottom += grid[1][i];
        }

        return ans;
    }
}