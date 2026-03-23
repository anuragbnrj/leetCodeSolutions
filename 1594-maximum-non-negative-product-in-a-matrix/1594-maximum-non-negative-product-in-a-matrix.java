class Solution {
    private final long MOD = (long) (1e9 + 7);

    public int maxProductPath(int[][] grid) {
        Long[][][] memo = new Long[grid.length][grid[0].length][];
        Long[] res = rec(0, 0, grid, memo);

        if (res[1] < 0) {
            return -1;
        }

        return (int) (res[1] % MOD);
    }

    private Long[] rec(int r, int c, int[][] grid, Long[][][] memo) {
        if (r == (grid.length - 1) && c == (grid[0].length - 1)) {
            return new Long[]{(long) grid[r][c], (long) grid[r][c]};
        }

        if (memo[r][c] != null) {
            return memo[r][c];
        }

        Long[] res = {(long) 1e15, -1L * (long) 1e15};
        if (r != (grid.length - 1)) {
            Long[] down = rec(r + 1, c, grid, memo);
            res[0] = Math.min(res[0], grid[r][c] * down[0]);
            res[0] = Math.min(res[0], grid[r][c] * down[1]);

            res[1] = Math.max(res[1], grid[r][c] * down[0]);
            res[1] = Math.max(res[1], grid[r][c] * down[1]);
        }

        if (c != (grid[0].length - 1)) {
            Long[] right = rec(r, c + 1, grid, memo);
            res[0] = Math.min(res[0], grid[r][c] * right[0]);
            res[0] = Math.min(res[0], grid[r][c] * right[1]);

            res[1] = Math.max(res[1], grid[r][c] * right[0]);
            res[1] = Math.max(res[1], grid[r][c] * right[1]);
        }

        memo[r][c] = res;

        return res;
    }
}