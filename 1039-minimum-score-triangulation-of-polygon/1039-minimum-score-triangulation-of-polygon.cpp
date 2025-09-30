class Solution {
public:
    int minScoreTriangulation(vector<int>& values) {
        int len = values.size();
        vector<vector<int>> dp(len + 1, vector<int>(len + 1, -1));
        return solve(0, len - 1, values, dp);   
    }

    int solve(int beg, int end, vector<int>& values, vector<vector<int>>& dp) {
        if ((end - beg) == 2) {
            return (values[beg] * values[beg + 1] * values[end]);
        }

        if ((end - beg) < 2) {
            return 0;
        }

        if (dp[beg][end] != -1) {
            return dp[beg][end];
        }

        int res = INT_MAX;

        for (int i = beg + 1; i < end; i++) {
            int temp = (values[beg] * values[i] * values[end]) + solve(beg, i , values, dp) + solve(i, end, values, dp);
            res = min(res, temp);
        }

        return dp[beg][end] = res;
    }
};