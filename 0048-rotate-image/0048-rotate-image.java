class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflectY(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c <= r; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    private void reflectY(int[][] matrix) {
        int n = matrix.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n - 1 - c];
                matrix[r][n - 1 - c] = temp;
            }
        }
    }
}