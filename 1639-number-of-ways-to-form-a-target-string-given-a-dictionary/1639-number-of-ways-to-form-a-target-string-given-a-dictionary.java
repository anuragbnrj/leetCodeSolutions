class Solution {
    private int MOD = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int len = words.length;
        int[][] freq = new int[words[0].length()][26];

        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);

                freq[j][ch - 'a'] += 1;
            }
        }

        long[][] dp = new long[words[0].length() + 1][target.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return (int) rec(0, 0, target, freq, dp);
    }

    private long rec(int wordIdx, int targetIdx, String target, int[][] freq, long[][] dp) {
        if (targetIdx >= target.length()) {
            return 1;
        }

        if (wordIdx >= freq.length) {
            return 0;
        }

        if (dp[wordIdx][targetIdx] != -1) {
            return dp[wordIdx][targetIdx];
        }

        long ans = 0;
        char ch = target.charAt(targetIdx);
        if (freq[wordIdx][ch - 'a'] > 0) {
            ans = (ans + freq[wordIdx][ch - 'a'] * rec(wordIdx + 1, targetIdx + 1, target, freq, dp)) % MOD;
        }

        ans = (ans + rec(wordIdx + 1, targetIdx, target, freq, dp)) % MOD;
        dp[wordIdx][targetIdx] = ans;

        return dp[wordIdx][targetIdx];
    }
}