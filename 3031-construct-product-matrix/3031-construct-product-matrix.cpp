class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        int mod = 12345;

        vector<vector<int>> res(rows, vector<int>(cols, 0));

        long long preProd = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res[r][c] = preProd;
                preProd = (preProd * grid[r][c]) % mod;
            }
        }

        long long sufProd = 1;
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                res[r][c] = (res[r][c] * sufProd) % mod;
                sufProd = (sufProd * grid[r][c]) % mod;
            }
        }

        return res; 
    }
};