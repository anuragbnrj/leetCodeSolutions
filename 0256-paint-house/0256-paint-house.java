class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;

        int[][] dp = new int[len][3];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = Math.min(rec(0, 0, costs, dp), Math.min(rec(0, 1, costs, dp), rec(0, 2, costs, dp)));

        return ans;
    }

    private int rec(int idx, int color, int costs[][], int[][] dp) {
        if (idx >= costs.length) {
            return 0;
        }

        if (dp[idx][color] != -1) {
            return dp[idx][color];
        }

        int ans = 0;
        if (color == 0) {
            ans = costs[idx][color] + Math.min(rec(idx + 1, 1, costs, dp), rec(idx + 1, 2, costs, dp));
        } else if (color == 1) {
            ans = costs[idx][color] + Math.min(rec(idx + 1, 0, costs, dp), rec(idx + 1, 2, costs, dp));
        } else {
            ans = costs[idx][color] + Math.min(rec(idx + 1, 0, costs, dp), rec(idx + 1, 1, costs, dp));
        }

        dp[idx][color] = ans;
        return ans;
    }
}