class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r][c] = -1;
            }
        }

        return getMinSumPath(rows - 1, cols - 1, grid, dp);
    }

    private int getMinSumPath(int r, int c, int[][] grid, int[][] dp) {
        if (r == 0 && c == 0) {
            return grid[r][c];
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int ans;
        if (r == 0) {
            ans = grid[r][c] + getMinSumPath(r, c - 1, grid, dp);
        } else if (c == 0) {
            ans = grid[r][c] + getMinSumPath(r - 1, c, grid, dp);
        } else {
            ans = grid[r][c] + Math.min(getMinSumPath(r, c - 1, grid, dp), getMinSumPath(r - 1, c, grid, dp));
        }

        dp[r][c] = ans;
        return dp[r][c];        
    }
}