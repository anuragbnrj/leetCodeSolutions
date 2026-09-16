class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        if (k == 0) return 1;
        if (k >= n) return 0;

        int total = n + k - 1;
        int choose = Math.min(2 * k, n - k - 1); // Binomial symmetry

        int[] dp = new int[choose + 1];
        dp[0] = 1;

        for (int row = 1; row <= total; row++) {
            for (int j = Math.min(row, choose); j >= 1; j--) {
                dp[j] += dp[j - 1];
                if (dp[j] >= MOD) dp[j] -= MOD;
            }
        }

        return dp[choose];
    }
}