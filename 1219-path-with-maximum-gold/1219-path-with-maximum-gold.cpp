class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
        //         cout << grid[r][c] << "\t"; 
        //     }
        //     cout << endl;
        // }

        int res = 0;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0) {
                    res = max(res, getMax(grid,rows, cols, r, c, visited));
                } 
            }
        }

        
        return res;
    }

private:
    int getMax(vector<vector<int>> &grid, int rows, int cols, int r, int c, vector<vector<bool>> &visited) {
        visited[r][c] = true;

        vector<int> dr = {-1, 0, 0, 1};
        vector<int> dc = {0, -1, 1, 0};

        int res = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(rows, cols, nr, nc) && !visited[nr][nc] && grid[nr][nc] > 0) {
                res = max(res, getMax(grid, rows, cols, nr, nc, visited));
            }
        }

        visited[r][c] = false;
        return grid[r][c] + res;
    }

    bool isValid(int rows, int cols, int r, int c) {
        if (r < 0 || rows <= r) {
            return false;
        }

        if (c < 0 || cols <= c) {
            return false;
        }

        return true;
    }
};