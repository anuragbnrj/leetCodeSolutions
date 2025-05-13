class Solution {
    private long MOD = (long) 1e9 + 7L;

    public int lengthAfterTransformations(String s, int t) {
        long[][] dp = new long[26][t + 1];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], -1);
        }

        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            ans = (ans + f(idx, t, dp)) % MOD;
        }

        return (int) ans;
    }

    private long f(int idx, int t, long[][] dp) {
        if (t == 0) {
            return 1;
        }

        if (dp[idx][t] != -1) {
            return dp[idx][t];
        }
        
        long ans;
        if (idx == 25) {
            ans = (f(0, t - 1, dp) + f(1, t - 1, dp)) % MOD;
        } else {
            ans = f(idx + 1, t - 1, dp);
        }

        dp[idx][t] = ans;

        return dp[idx][t];
    }
}