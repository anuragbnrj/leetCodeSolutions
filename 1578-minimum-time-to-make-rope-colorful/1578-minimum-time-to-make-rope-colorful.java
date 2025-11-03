class Solution {
    public int minCost(String colors, int[] neededTime) {
        int len = colors.length();
        int[][] dp = new int[len + 1][27];
        for (int r = 0; r < len + 1; r++) {
            Arrays.fill(dp[r], -1);
        }

        return rec(0, 26, colors, neededTime, dp);
    }

    private int rec(int idx, int prev, String colors, int[] neededTime, int[][] dp) {
        if (idx >= colors.length()) {
            return 0;
        }

        if (dp[idx][prev] != -1) {
            return dp[idx][prev];
        }

        int curr = colors.charAt(idx) - 'a';
        int p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;

        // pick current
        if (curr != prev) {
            p1 = rec(idx + 1, curr, colors, neededTime, dp);
        }

        // don't pick current
        p2 = neededTime[idx] + rec(idx + 1, prev, colors, neededTime, dp);

        dp[idx][prev] = Math.min(p1, p2);
        return dp[idx][prev];   
    }
}