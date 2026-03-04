class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    rowCount[r] += 1;
                    colCount[c] += 1;
                }
            }
        }
        
        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1 && rowCount[r] == 1 && colCount[c] == 1) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}