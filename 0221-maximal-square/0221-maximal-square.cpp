class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        vector<vector<int>> m(rows, vector<int>(cols, 0));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    m[i][j] = 1;
                } else {
                    m[i][j] = 0;
                }
            }
        }

        int maxLen = INT_MIN;
        vector<vector<int>> dp = m;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i > 0 && j > 0 && dp[i][j] == 1) {
                    int prev = dp[i - 1][j - 1];
                    
                    int onesx = 0;
                    for (int ctr = 0; ctr < prev + 1; ctr++) {
                        if (m[i][j - ctr] == 1) {
                            onesx++;
                        } else {
                            break;
                        }
                    }

                    int onesy = 0;
                    for (int ctr = 0; ctr < prev + 1; ctr++) {
                        if (m[i - ctr][j] == 1) {
                            onesy++;
                        } else {
                            break;
                        }
                    }

                    
                    dp[i][j] = max(dp[i][j], min(onesx, onesy));
                    
                }

                maxLen = max(maxLen, dp[i][j]);
            }
        }

        return maxLen * maxLen;
    }
};