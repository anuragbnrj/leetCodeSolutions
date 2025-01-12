class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(0, len - 1, s, dp);
    }

    private int rec(int beg, int end, String s, int[][] dp) {
        if (beg == end) {
            return 1;
        }

        if (beg > end) {
            return 0;
        }

        if (dp[beg][end] != -1) {
            return dp[beg][end];
        }

        int ans = 0;
        if (s.charAt(beg) == s.charAt(end)) {
            ans = 2 + rec(beg + 1, end - 1, s, dp);
        } else {
            ans = Math.max(rec(beg + 1, end, s, dp), rec(beg, end - 1, s, dp));
        }

        dp[beg][end] = ans;
        return ans;
    }
}