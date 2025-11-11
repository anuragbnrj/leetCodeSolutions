class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        
        int[][] counts = new int[len][2];
        for (int idx = 0; idx < len; idx++) {
            String str = strs[idx];
            int zeroes = 0;
            int ones = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeroes += 1;
                } else {
                    ones += 1;
                }
            }

            counts[idx][0] = zeroes;
            counts[idx][1] = ones;
        }

        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return rec(0, strs, m, n, counts, dp);
    }

    private int rec(int idx, String[] strs, int maxZeroes, int maxOnes, int[][] counts, int[][][] dp) {
        if (idx >= strs.length) {
            return 0;
        }

        if (dp[idx][maxZeroes][maxOnes] != -1) {
            return dp[idx][maxZeroes][maxOnes];
        }

        // pick
        int p1 = 0, p2 = 0;
        if (counts[idx][0] <= maxZeroes && counts[idx][1] <= maxOnes) {
            p1 = 1 + rec(idx + 1, strs, maxZeroes - counts[idx][0], maxOnes - counts[idx][1], counts, dp);
        }

        // not pick
        p2 = rec(idx + 1, strs, maxZeroes, maxOnes, counts, dp);

        dp[idx][maxZeroes][maxOnes] = Math.max(p1, p2);

        return dp[idx][maxZeroes][maxOnes];
    }
}