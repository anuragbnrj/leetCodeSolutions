class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        int[][] ans = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int mn = Math.min(rowSum[r], colSum[c]);
                rowSum[r] -= mn;
                colSum[c] -= mn;

                ans[r][c] = mn;
            }
        }

        return ans;
    }
}