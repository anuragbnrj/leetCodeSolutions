class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

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

        int res = 0;
        for (int r = 0; r < rows; r++) {
            int curr = 0;
            int pow = 1;
            for (int c = cols - 1; c >= 0; c--) {
                curr += (pow * grid[r][c]);
                pow *= 2;
            }
            res += curr;
        }

        return res;
        
    }
}