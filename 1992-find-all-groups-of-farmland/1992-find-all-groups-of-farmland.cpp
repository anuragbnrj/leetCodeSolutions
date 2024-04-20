class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        int rows = land.size();
        int cols = land[0].size();

        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        vector<vector<int>> res;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && land[r][c] == 1) {
                    // cout << r << " " << c << endl;
                    res.push_back({r, c, 0, 0});
                    dfs(land, visited, rows, cols, r, c, res);
                }
            }
        }

        return res;
    }

private:
    void dfs(vector<vector<int>>& land, vector<vector<bool>> &visited, int rows, int cols, int r, int c, 
    vector<vector<int>> &res) {
        visited[r][c] = true;
        
        auto &back = res.back();
        if (r >= back[2] && c >= back[3]) {
            back[2] = r;
            back[3] = c;
        }

        int dr[] = {0, 1};
        int dc[] = {1, 0};

        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && land[nr][nc] == 1) {
                dfs(land, visited, rows, cols, nr, nc, res);
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