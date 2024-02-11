class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        vector<vector<vector<int>>> dp(rows, vector<vector<int>> (cols, vector<int>(cols, -1)));
        return solve(0, 0, cols - 1, rows, cols, grid, dp);
    }

private:
    int solve(int r, int c1, int c2, int rows, int cols, vector<vector<int>> &grid, vector<vector<vector<int>>> &dp) {
        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        if (r == rows - 1) {
            if (c1 == c2) {
                return dp[r][c1][c2] = grid[r][c1];
            } else {
                return dp[r][c1][c2] = grid[r][c1] + grid[r][c2];
            }
        }

        int dc[] = {-1, 0, 1};

        int nr = r + 1;
        int nc1, nc2;
        int mx = INT_MIN;
        for (int i = 0; i < 3; i++) {
            int nc1 = c1 + dc[i];
            for (int j = 0; j < 3; j++) {
                int nc2 = c2 + dc[j];

                if (isOk(nr, nc1, rows, cols) && isOk(nr, nc2, rows, cols)) {
                    mx = max(mx, solve(nr, nc1, nc2, rows, cols, grid, dp));
                }
            }
        }

        if (c1 == c2) {
            return dp[r][c1][c2] = mx + grid[r][c1];
        } else {
            return dp[r][c1][c2] = mx + grid[r][c1] + grid[r][c2];
        }
    }

    bool isOk(int nr, int nc, int rows, int cols) {
        if (nr < 0 || rows <= nr) {
            return false;
        }

        if (nc < 0 || cols <= nc) {
            return false;
        }

        return true;
    }
};