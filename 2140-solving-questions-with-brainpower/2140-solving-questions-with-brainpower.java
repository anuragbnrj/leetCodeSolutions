class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 5];
        Arrays.fill(dp, -1);

        long ans = rec(0, questions, dp);

        return ans;
    }

    private long rec(int idx, int[][] questions, long[] dp) {
        if (idx >= questions.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        long ans = rec(idx + 1, questions, dp);

        long points = questions[idx][0];
        int skip = questions[idx][1];
        ans = Math.max(ans, points + rec(idx + skip + 1, questions, dp));

        dp[idx] = ans;
        return ans;
    }
}