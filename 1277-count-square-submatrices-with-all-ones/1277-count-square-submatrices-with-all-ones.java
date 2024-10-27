class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] psum = new int[rows + 1][cols + 1];

        int ans = 0;
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                psum[r][c] = matrix[r - 1][c - 1];

                if (psum[r][c] == 0) continue;

                psum[r][c] = 1 + Math.min(Math.min(psum[r - 1][c - 1], psum[r - 1][c]), psum[r][c - 1]);

                ans += psum[r][c];
            }
        }

        return ans;
    }
}