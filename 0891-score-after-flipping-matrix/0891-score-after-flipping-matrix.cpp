class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 0) {
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = 1 - grid[r][c];
                }
            }
        }

        for (int c = 0; c < cols; c++) {
            int zeros = 0;
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] == 0) {
                    zeros++;
                }
            }

            if (zeros > (rows / 2)) {
                for (int r = 0; r < rows; r++) {
                    grid[r][c] = 1 - grid[r][c];
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c= 0; c < cols; c++) {
                cout << grid[r][c] << "\t";
            }
            cout << endl;
        }

        int res = 0;
        for (int r = 0; r < rows; r++) {
            int curr = 0;
            int pow = 1;
            for (int c = cols - 1; c >= 0; c--) {
                curr += (pow * grid[r][c]);
                pow *= 2;
            }
            cout << curr << endl;
            res += curr;
        }

        return res;
        

    }
};