class Solution {
    private long MOD = (long) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 5];
        Arrays.fill(dp, -1);

        long ans = rec(0, low, high, zero, one, dp);

        return (int) ans;
    }

    private long rec(int currLen, int low, int high, int z, int o, long[] dp) {
        if (currLen > high) {
            return 0;
        }

        if (dp[currLen] != -1) {
            return dp[currLen];
        }

        long ans = 0;
        if (low <= currLen && currLen <= high) {
            ans = 1;
        }

        ans = (ans + rec(currLen + z, low, high, z, o, dp)) % MOD;
        ans = (ans + rec(currLen + o, low, high, z, o, dp)) % MOD;
        dp[currLen] = ans;

        return dp[currLen];
    }
}