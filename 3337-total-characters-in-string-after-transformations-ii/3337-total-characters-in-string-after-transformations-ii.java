class Solution {
    private long MOD = (long) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int len = s.length();

        long[][] dp = new long[26][t + 1];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], -1);
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            ans = (ans + f(idx, t, nums, dp)) % MOD;
        }

        return (int) ans;
    }

    private long f(int idx, int t, List<Integer> nums, long[][] dp) {
        if (t == 0) {
            return 1;
        }

        if (dp[idx][t] != -1) {
            return dp[idx][t];
        }
        
        long ans = 0;
        for (int i = 0; i < nums.get(idx); i++) {
            ans = (ans + f((idx + i + 1) % 26, t - 1, nums, dp)) % MOD;
        }

        dp[idx][t] = ans;

        return ans;
    }
    
}