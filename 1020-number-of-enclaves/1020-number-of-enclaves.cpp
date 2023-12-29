class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<int>> canReach(rows, vector<int>(cols, -1));

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == (rows - 1) || c == 0 || c == (cols - 1)) {
                    if (grid[r][c] == 1 && canReach[r][c] == -1) {
                        dfs(r, c, rows, cols, grid, canReach);
                    }
                }
            }
        }

        int res = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && canReach[r][c] == -1) {
                    res += 1;
                }
            }
        }
        
        return res;
    }

private:
    void dfs(int r, int c, int rows, int cols, vector<vector<int>>& grid, vector<vector<int>>& canReach) {
        canReach[r][c] = 1;

        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isValid(nr, nc, rows, cols) && canReach[nr][nc] == -1 && grid[nr][nc] == 1) {
                dfs(nr, nc, rows, cols, grid, canReach);
            }
        }
    }

    bool isValid(int r, int c, int rows, int cols) {
        if (r < 0 || rows <= r) {
            return false;
        }

        if (c < 0 || cols <= c) {
            return false;
        }

        return true;
    }
};