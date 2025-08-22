class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int left = 1000, right = 0;
        int up = 1000, down = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (r < up) up = r;
                    if (r > down) down = r;

                    if (c < left) left = c;
                    if (c > right) right = c;
                }
            }
        }

        return (down - up + 1) * (right - left + 1);
    }
}