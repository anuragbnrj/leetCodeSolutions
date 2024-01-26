class Solution {
public:
    int MOD = 1000000007;
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        vector<vector<vector<int>>> dp(m + 1, vector<vector<int>>(n + 1, vector<int>(maxMove + 1, -1)));
        return solve(startRow, startColumn, maxMove, m, n, dp);
    }

    long long solve(int row, int col, int movesLeft, int m, int n, vector<vector<vector<int>>>& dp) {
        if (row < 0 || row == m) {
            return 1;
        }

        if (col < 0 || col == n) {
            return 1;
        }

        if (movesLeft <= 0) {
            return 0;
        }

        if (dp[row][col][movesLeft] != -1) {
            return dp[row][col][movesLeft];
        }

        long long res = 0;

        res = (res + solve(row - 1, col, movesLeft - 1, m, n, dp)) % MOD;
        res = (res + solve(row, col - 1, movesLeft - 1, m, n, dp)) % MOD;
        res = (res + solve(row, col + 1, movesLeft - 1, m, n, dp)) % MOD;
        res = (res + solve(row + 1, col, movesLeft - 1, m, n, dp)) % MOD;

        return dp[row][col][movesLeft] = res ;
    }
};