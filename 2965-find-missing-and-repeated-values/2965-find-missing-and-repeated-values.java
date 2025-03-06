class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int n = rows * cols;
        int expectedSum = (n * (n + 1)) / 2;
        int repeating = -1;
        int missing = -1;

        int sum = 0;
        int[] freq = new int[rows * cols + 1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int curr = grid[r][c];

                if (freq[curr] > 0) {
                    repeating = curr;
                }

                freq[curr] += 1;
                sum += curr;
            }
        }

        missing = expectedSum - sum + repeating;

        return new int[]{repeating, missing};
    }
}