class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        vector<vector<int>> dp(rows, vector<int>(cols, 0));
        int maxLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int a = 0, b = 0, c = 0;
                    if (i > 0 && j > 0) {
                        a = dp[i - 1][j - 1] + 1;
                    }

                    if (i > 0) {
                        b = dp[i - 1][j] + 1;
                    }

                    if (j > 0) {
                        c = dp[i][j - 1] + 1;
                    }

                    int mini = min({a, b, c});

                    dp[i][j] = max(1, mini);
                    maxLen = max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
};