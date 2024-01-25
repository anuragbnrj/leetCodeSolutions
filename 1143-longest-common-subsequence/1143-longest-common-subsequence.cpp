class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> dp(1001, vector<int>(1001, -1));
        return solve(0, 0, text1, text2, dp);
    }

private:
    int solve(int idx1, int idx2, string &a, string &b, vector<vector<int>> &dp) {
        int la = a.size();
        int lb = b.size();
        if (idx1 == la || idx2 == lb) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        int c1 = 0, c2 = 0, c3 = 0;
        if (a[idx1] == b[idx2]) {
            c1 = 1 + solve(idx1 + 1, idx2 + 1, a, b, dp);
        }

        c2 = solve(idx1 + 1, idx2, a, b, dp);
        c3 = solve(idx1, idx2 + 1, a, b, dp);

        return dp[idx1][idx2] = max({c1, c2, c3});
    }
};