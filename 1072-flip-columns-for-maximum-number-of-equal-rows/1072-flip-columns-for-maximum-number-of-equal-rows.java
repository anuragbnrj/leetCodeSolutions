class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            int[] currRow = matrix[r];
            int[] currRowInv = new int[cols];
            for (int c = 0; c < cols; c++) {
                currRowInv[c] = 1 - currRow[c];
            }

            int ctr = 0;
            for (int i = 0; i < rows; i++) {
                if (Arrays.equals(currRow, matrix[i]) || Arrays.equals(currRowInv, matrix[i])) {
                    ctr += 1;
                }
            }

            ans = Math.max(ans, ctr);
        }

        return ans;
    }
}