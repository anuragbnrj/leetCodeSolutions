class Solution {
    int n;
    int[] psum;
    int[][] dp;
    boolean[][] done;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        psum = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            psum[i] = psum[i + 1] + piles[i];
        }

        dp = new int[n + 1][2 * n + 1];
        done = new boolean[n + 1][2 * n + 1];

        int ans = rec(0, 1);
        return ans;
    }

    private int rec(int idx, int m) {
        if (idx >= n) {
            return 0;
        }

        if (done[idx][m] == true) {
            return dp[idx][m];
        }

        int ans = 0;
        for (int i = idx; i < idx + (2 * m) && i < n; i++) {
            int temp = psum[idx] - rec(i + 1, Math.max(m, i - idx + 1));
            ans = Math.max(ans, temp);
        }

        // System.out.println("idx: " + idx + ", m: " + m + ", ans: " + ans);
        done[idx][m] = true;
        dp[idx][m] = ans;
        return ans;
    }
}