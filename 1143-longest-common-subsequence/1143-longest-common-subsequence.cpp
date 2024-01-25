class Solution {
public:
    int longestCommonSubsequence(string a, string b) {
        int la = a.size();
        int lb = b.size(); 
        vector<vector<int>> dp(1001, vector<int>(1001, 0));

        for (int i = la - 1; i >= 0; i--) {
            for (int j = lb - 1; j >= 0; j--) {
                int c1 = 0, c2 = 0, c3 = 0;
                if (a[i] == b[j]) {
                    c1 = 1 + dp[i + 1][j + 1];
                }

                c2 = dp[i + 1][j];
                c3 = dp[i][j + 1];

                dp[i][j] = max({c1, c2, c3});
            }
        }

        return dp[0][0];
    }
};