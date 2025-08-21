class Solution {
    /**
     * Calculates the number of submatrices containing all ones.
     *
     * @param mat The input matrix of 0s and 1s.
     * @return The total number of submatrices with all ones.
     */
    public int numSubmat(int[][] mat) {
        // Handle edge cases where the matrix is null or empty.
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        // Step 1: Create a new matrix (or modify in-place) to store the sum of
        // consecutive ones above each cell.
        // We can modify the input matrix `mat` to save space.
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    // If the current cell is 1, add the value from the cell directly above it.
                    // This creates a histogram-like representation where each mat[i][j]
                    // stores the height of a bar of ones ending at that cell.
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }

        // Step 2 & 3: Traverse the modified matrix row by row.
        // For each cell, treat it as the bottom-right corner of potential submatrices.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell's value is 0, it cannot be part of any submatrix.
                if (mat[i][j] == 0) {
                    continue;
                }

                // Initialize minHeight for the current traversal to the left.
                // We start with the height of the current bar.
                int minHeight = mat[i][j];

                // Traverse leftwards from the current column `j`.
                for (int k = j; k >= 0; k--) {
                    // If we encounter a 0, we can't extend the submatrix further left.
                    if (mat[i][k] == 0) {
                        break;
                    }
                    
                    // Step 4: While traversing left, find the minimum height of the bars
                    // encountered so far. This minimum height determines the height of
                    // the submatrices we can form.
                    minHeight = Math.min(minHeight, mat[i][k]);
                    
                    // The number of submatrices that can be formed with the current width
                    // (from k to j) is equal to this minimum height.
                    // For example, if minHeight is 3, we can form submatrices of height 1, 2, and 3.
                    count += minHeight;
                }
            }
        }

        return count;
    }
}