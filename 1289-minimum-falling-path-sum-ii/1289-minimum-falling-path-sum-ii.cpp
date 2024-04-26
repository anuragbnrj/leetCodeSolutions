class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        vector<vector<int>> dp(rows + 1, vector<int>(cols + 1, -1));
        int res = INT_MAX;
        for (int c = 0; c < cols; c++) {
            res = min(res, solve(grid, rows, cols, rows - 1, c, dp));
        }

        return res;
    }

private:
    int solve(vector<vector<int>> &grid, int rows, int cols, int r, int c, vector<vector<int>> &dp) {
        if (r == 0) {
            return dp[r][c] = grid[r][c];
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int temp = INT_MAX;
        int dr[] = {-1, -1};
        int dc[] = {-1, 1};
        for (int i = 0; i < cols; i++) {
            if (i == c) {continue;}

            temp = min(temp, solve(grid, rows, cols, r - 1, i, dp));
            // int nr = r + dr[i];
            // int nc = c + dc[i];
            // if (isValid(rows, cols, nr, nc)) {
            //     temp = min(temp, solve(grid, rows, cols, nr, nc, dp));
            // }
        }

        dp[r][c] = temp + grid[r][c];
        return dp[r][c];
    }

    // bool isValid(int rows, int cols, int r, int c) {
    //     if (r < 0 || rows <= r) {
    //         return false;
    //     }

    //     if (c < 0 || cols <= c) {
    //         return false;
    //     }

    //     return true;
    // }
};