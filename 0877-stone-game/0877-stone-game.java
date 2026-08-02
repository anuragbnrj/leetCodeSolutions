class Solution {
    public boolean stoneGame(int[] piles) {
        int size = piles.length;

        int totalStones = 0;
        for (int pile : piles) {
            totalStones += pile;
        }

        int[][] dp = new int[size + 1][size + 1];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (maxDiff(0, size - 1, piles, dp) > 0);
    }

    private int maxDiff(int l, int r, int[] piles, int[][] dp) {
        if (l == r) {
            return piles[l];
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int res = Math.max(
            piles[l] - maxDiff(l + 1, r, piles, dp),
            piles[r] - maxDiff(l, r - 1, piles, dp)  
        );

        dp[l][r] = res;
        return res;
    }
}