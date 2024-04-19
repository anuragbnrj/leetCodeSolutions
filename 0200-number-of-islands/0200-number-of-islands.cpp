class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        int res = 0;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    res++;
                    dfs(grid, visited, rows, cols, r, c);
                }
            }
        }

        return res;
    }
private:
    void dfs(vector<vector<char>>& grid, vector<vector<bool>> &visited, int rows, int cols, int r, int c) {
        visited[r][c] = true;

        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isValid(nr, nc, rows, cols)) {continue;}

            if (!visited[nr][nc] && grid[nr][nc] == '1') {
                dfs(grid, visited, rows, cols, nr, nc);
            }
        }
    }

    bool isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || rows <= nr) {
            return false;
        }

        if (nc < 0 || cols <= nc) {
            return false;
        }

        return true;
    }
};