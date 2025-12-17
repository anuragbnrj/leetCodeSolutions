class Solution {
    private static final long LONG_MIN = -10000000000000000L;

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        // state: 0 = flat, 1 = long open, 2 = short open
        long[][][] dp = new long[n + 1][k + 1][3];
        for (int i = 0; i <= n; i++) {
            for (int t = 0; t <= k; t++) {
                Arrays.fill(dp[i][t], LONG_MIN);
            }
        }
        return rec(0, k, 0, prices, dp);
    }

    // state: 0 = flat, 1 = long open, 2 = short open
    private long rec(int idx, int k, int state, int[] prices, long[][][] dp) {
        if (k == 0) {
            return state == 0 ? 0 : LONG_MIN; // cannot close/open further
        }
        if (idx == prices.length) {
            return state == 0 ? 0 : LONG_MIN; // must be flat at end
        }
        if (dp[idx][k][state] != LONG_MIN) return dp[idx][k][state];

        long res = LONG_MIN;

        if (state == 0) { // flat: skip or open
            // skip today
            res = Math.max(res, rec(idx + 1, k, 0, prices, dp));
            // open long (buy today) — only if we can eventually close within k
            res = Math.max(res, -prices[idx] + rec(idx + 1, k, 1, prices, dp));
            // open short (sell today)
            res = Math.max(res, +prices[idx] + rec(idx + 1, k, 2, prices, dp));
        } else if (state == 1) { // holding long: hold or close
            // hold
            res = Math.max(res, rec(idx + 1, k, 1, prices, dp));
            // close long (sell today) -> completes one transaction
            res = Math.max(res, prices[idx] + rec(idx + 1, k - 1, 0, prices, dp));
        } else { // state == 2, holding short: hold or close
            // hold
            res = Math.max(res, rec(idx + 1, k, 2, prices, dp));
            // close short (buy back today) -> completes one transaction
            res = Math.max(res, -prices[idx] + rec(idx + 1, k - 1, 0, prices, dp));
        }

        dp[idx][k][state] = res;
        return res;
    }
}