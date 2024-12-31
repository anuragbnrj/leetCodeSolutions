class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp = new int[400][400];
        for (int i = 0; i < 400; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = rec(0, 0, days, costs, dp);

        return ans;
    }

    private int rec(int idx, int canGoTill, int[] days, int[] costs, int[][] dp) {
        if (idx >= days.length) {
            return 0;
        }

        if (dp[idx][canGoTill] != -1) {
            return dp[idx][canGoTill];
        }

        int currDay = days[idx];
        if (canGoTill >= currDay) {
            return rec(idx + 1, canGoTill, days, costs, dp);
        }

        int ans = (int) 1e9;
        ans = Math.min(ans, costs[0] + rec(idx + 1, currDay, days, costs, dp));
        ans = Math.min(ans, costs[1] + rec(idx + 1, currDay + 6, days, costs, dp));
        ans = Math.min(ans, costs[2] + rec(idx + 1, currDay + 29, days, costs, dp));

        dp[idx][canGoTill] = ans;

        return ans;
    }
}