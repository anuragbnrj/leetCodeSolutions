class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] psum = new int[rows + 1][cols + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                psum[r][c] = mat[r - 1][c - 1] + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];
            }
        }

        int beg = 0;
        int end = Math.min(rows, cols) + 1;
        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (isPossible(rows, cols, threshold, psum, mid)) beg = mid + 1;
            else end = mid;
        }

        return beg - 1;
    }

    private boolean isPossible(int rows, int cols, int threshold, int[][] psum, int mid) {

        for (int r = mid; r <= rows; r++) {
            for (int c = mid; c <= cols; c++) {
                int mat_sum = psum[r][c] - psum[r][c - mid] - psum[r - mid][c] + psum[r - mid][c - mid];

                if (mat_sum <= threshold) return true;
            }
        }

        return false;
    }
}