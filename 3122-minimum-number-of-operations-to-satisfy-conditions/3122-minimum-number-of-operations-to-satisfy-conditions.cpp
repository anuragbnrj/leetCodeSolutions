class Solution {
public:
    int res = INT_MAX;
    int minimumOperations(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        vector<vector<int>> dp(cols + 1, vector<int>(11, -1));
        res = solve(grid, rows, cols, 0, 10, dp);
        
        return res;
    }

private:
    int solve(vector<vector<int>>& grid, int rows, int cols, int c, int prev, vector<vector<int>> &dp) {
        if (dp[c][prev] != -1) {
            return dp[c][prev];
        }

        if (c >= cols) {
            return 0;
        }

        // cout << rows << " " << cols << " " << c << " " << prev << endl; 
        
        int res = INT_MAX;
        for (int k = 0; k <= 9; k++) {
            
            if (k != prev) {
                int newMoves = 0;
                for (int r = 0; r < rows; r++) {
                    if (grid[r][c] != k) {
                        newMoves++;
                    } 
                }
                
                res = min(res, newMoves + solve(grid, rows, cols, c + 1, k, dp));
            }
            
        }

        return dp[c][prev] = res;
    }
};
