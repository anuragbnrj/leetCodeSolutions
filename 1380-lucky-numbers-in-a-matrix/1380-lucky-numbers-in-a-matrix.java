class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] rowMin = new int[rows];
        for (int r = 0; r < rows; r++) {
            int currRowMin = (int) 1e9;
            for (int c = 0; c < cols; c++) {
                currRowMin = Math.min(currRowMin, matrix[r][c]);
            }
            rowMin[r] = currRowMin;
        }

        int[] colMax = new int[cols];
        for (int c = 0; c < cols; c++) {
            int currColMax = -1;
            for (int r = 0; r < rows; r++) {
                currColMax = Math.max(currColMax, matrix[r][c]);
            }
            colMax[c] = currColMax;
        }

        List<Integer> ans = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == rowMin[r] && matrix[r][c] == colMax[c]) {
                    ans.add(matrix[r][c]);
                }
            }
           
        }

        return ans;
    }
}