class Solution {
    int INF = (int) 1e9;
    int[][] dp = new int[1002][1002];

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }

        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                dp[r][c] = -1;
            }
        }

        int ans = 1 + rec(1, 1, n);

        return ans;
    }

    private int rec(int inBuffer, int onScreen, int n) {
        if (onScreen == n) {
            return 0;
        } 

        if (onScreen > n) {
            return INF;
        }

        if (dp[inBuffer][onScreen] != -1) {
            return dp[inBuffer][onScreen];
        }

        // No Copy
        int ch1 = 1 + rec(inBuffer, onScreen + inBuffer, n);

        // Copy
        int ch2 = 2 + rec(inBuffer + onScreen, onScreen + inBuffer, n);

        int ans = Math.min(ch1, ch2);
        dp[inBuffer][onScreen] = ans;
        return ans;
    }
}