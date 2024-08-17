class Solution {
    int rows;
    int cols;

    public long maxPoints(int[][] points) {
        rows = points.length;
        cols = points[0].length;

        long[] prevRow = new long[cols];
        for (int c = 0; c < cols; c++) {
            prevRow[c] = points[0][c];
        }

        for (int r = 1; r < rows; r++) {
            long[] leftMax = new long[cols];
            leftMax[0] = prevRow[0];
            for (int c = 1; c < cols; c++) {
                leftMax[c] = Math.max(prevRow[c], leftMax[c - 1] - 1);
            }

            long[] rightMax = new long[cols];
            rightMax[cols - 1] = prevRow[cols - 1];
            for (int c = cols - 2; c >= 0; c--) {
                rightMax[c] = Math.max(prevRow[c], rightMax[c + 1] - 1);
            }

            long[] currRow = new long[cols];
            for (int c = 0; c < cols; c++) {
                currRow[c] = Math.max(leftMax[c], rightMax[c]) + points[r][c];
            }

            prevRow = currRow;
        }

        long ans = 0;
        for (int c = 0; c < cols; c++) {
            ans = Math.max(ans, prevRow[c]);
        }

        return ans; 
    }
}