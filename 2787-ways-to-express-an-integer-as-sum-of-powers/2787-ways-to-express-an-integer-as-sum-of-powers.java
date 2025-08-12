class Solution {
    private long MOD = (long) 1e9 + 7;

    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 1;; i++) {
            int pwr = intPow(i, x);
            if (pwr > n)
                break;
            powers.add(pwr);
        }

        long[][] dp = new long[n + 1][powers.size() + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long ans = rec(n, 0, powers, dp);

        return (int) ans;
    }

    private long rec(int n, int idx, List<Integer> powers, long[][] dp) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n][idx] != -1) {
            return dp[n][idx];
        }

        long ans = 0;
        for (int i = idx; i < powers.size(); i++) {
            int pwr = powers.get(i);

            ans = (ans + rec(n - pwr, i + 1, powers, dp)) % MOD;
        }

        dp[n][idx] = ans;
        return ans;
    }

    private int intPow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}