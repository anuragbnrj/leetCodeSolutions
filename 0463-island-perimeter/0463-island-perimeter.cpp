class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};

        int peri = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int i = 0; i < 4; i++) {
                    if (grid[r][c] == 0) continue;

                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (!isValid(nr, nc, rows, cols)) {
                        peri += 1;
                    } else {
                        if (grid[nr][nc] == 0) {
                            peri += 1;
                        }
                    }
                     
                }
            }
        }

        return peri;
    }

private:
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