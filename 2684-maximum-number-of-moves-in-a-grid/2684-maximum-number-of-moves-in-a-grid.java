class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r][c] = -1;
            }
        }

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            ans = Math.max(ans, rec(r, 0, grid, dp, rows, cols, -1));
        }

        return ans - 1;
    }

    private int rec(int r, int c, int[][] grid, int[][] dp, int rows, int cols, int prev) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] <= prev) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int curr = grid[r][c];
        int ch1 = rec(r - 1, c + 1, grid, dp, rows, cols, curr);
        int ch2 = rec(r, c + 1, grid, dp, rows, cols, curr);
        int ch3 = rec(r + 1, c + 1, grid, dp, rows, cols, curr);

        dp[r][c] = 1 + Math.max(Math.max(ch1, ch2), ch3);

        return dp[r][c];
    }
}