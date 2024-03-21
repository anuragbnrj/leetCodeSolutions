class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        vector<vector<int>> dp(rows, vector<int>(cols, INT_MAX));
        dp[0][0] = grid[0][0];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int curr = grid[r][c];
                if (r > 0) {
                    dp[r][c] = min(dp[r][c], curr + dp[r - 1][c]);
                }

                if (c > 0) {
                    dp[r][c] = min(dp[r][c], curr + dp[r][c - 1]);
                }
            }
        }

        return dp[rows - 1][cols - 1];
        
    }
};