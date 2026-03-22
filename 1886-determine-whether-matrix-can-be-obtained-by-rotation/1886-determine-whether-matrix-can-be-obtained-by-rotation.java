class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        if (isEqual(mat, target) || isEqual(rotate90(mat), target) || isEqual(rotate90(rotate90(mat)), target) ||
        isEqual(rotate90(rotate90(rotate90(mat))), target)) {
            return true;
        }

        return false;
    }

    private boolean isEqual(int[][] src, int[][] tar) {
        int rows = src.length;
        int cols = src[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (src[r][c] != tar[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] rotate90(int[][] mat) {
        int rows = mat.length;
        int cols = mat.length;
        int[][] rotated = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated[c][rows - 1 - r] = mat[r][c];
            }
        }

        return rotated;
    }
}