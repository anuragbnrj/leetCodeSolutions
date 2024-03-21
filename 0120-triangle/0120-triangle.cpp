class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int rows = triangle.size();
        int grcols = triangle[rows - 1].size();

        vector<vector<int>> dp(rows, vector<int>(grcols, INT_MAX));
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < rows; i++) {
            int cols = triangle[i].size();
            // int prevcols = cols - 1;

            dp[i][0] = min(dp[i][0], triangle[i][0] + dp[i - 1][0]);
            for (int j = 1; j < cols - 1; j++) {
                dp[i][j] = min(dp[i][j], triangle[i][j] + dp[i - 1][j]);
                dp[i][j] = min(dp[i][j], triangle[i][j] + dp[i - 1][j - 1]);
            }
            dp[i][cols - 1] = min(dp[i][cols - 1], triangle[i][cols - 1] + dp[i - 1][cols - 1 - 1]);
        }

        int res = INT_MAX;
        for (int c = 0; c < grcols; c++) {
            res = min(res, dp[rows - 1][c]);
        }

        return res; 
    }
};