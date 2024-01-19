class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        vector<vector<int>> dp(rows, vector<int>(cols, INT_MAX));
        for (int c = 0; c < cols; c++) {
            dp[0][c] = matrix[0][c];
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isValid(r - 1, c, rows, cols)) {
                    dp[r][c] = min(dp[r][c], dp[r - 1][c] + matrix[r][c]);
                }

                if (isValid(r - 1, c - 1, rows, cols)) {
                     dp[r][c] = min(dp[r][c], dp[r - 1][c - 1] + matrix[r][c]);
                }

                if (isValid(r - 1, c + 1, rows, cols)) {
                     dp[r][c] = min(dp[r][c], dp[r - 1][c + 1] + matrix[r][c]);
                }
            }
        }

        int res = INT_MAX;
        for (int c = 0; c < cols; c++) {
            res = min(res, dp[rows - 1][c]);
        }

        return res;
    }

private:
    bool isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || rows <= nr) {
            return false;
        }

        if (nc < 0 || cols <= nc) {
            return false;
        }

        return true;
    }
};