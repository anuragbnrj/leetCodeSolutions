class Solution {
public:
    void solve(vector<vector<char>>& mat) {
        int rows = mat.size();
        int cols = mat[0].size();
        vector<vector<int>> canReach(rows, vector<int>(cols, -1));
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == (rows - 1) || c == 0 || c == (cols - 1)) {
                    if (mat[r][c] == 'O') {
                        dfs(r, c, rows, cols, mat, canReach);
                    }
                    
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 'O' && canReach[r][c] == -1) {
                    mat[r][c] = 'X';
                }
            }
        }
    }

private:
    void dfs(int r, int c, int rows, int cols, vector<vector<char>> &mat, vector<vector<int>> &canReach) {
        canReach[r][c] = 1;
        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && mat[nr][nc] == 'O' && canReach[nr][nc] == -1) {
                dfs(nr, nc, rows, cols, mat, canReach);
            }
        }
    }
    
    bool isValid(int r, int c, int n, int m) {
        if (r < 0 || n <= r) {
            return false;
        }
        
        if (c < 0 || m <= c) {
            return false;
        }
        
        return true;
    }
};