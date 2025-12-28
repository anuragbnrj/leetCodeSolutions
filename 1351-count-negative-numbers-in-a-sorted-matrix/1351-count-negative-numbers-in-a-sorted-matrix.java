class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int ans = 0;
        int prevRowFirstNegativeIdx = cols; 
        for (int r = 0; r < rows; r++) {
            int negativeIdx = getNegativeIdx(grid, r, prevRowFirstNegativeIdx);

            if (negativeIdx < cols) {
                ans += (cols - negativeIdx);
            }

            prevRowFirstNegativeIdx = negativeIdx;
        }
        
        return ans;
    }

    private int getNegativeIdx(int[][] grid, int r, int prevRowFirstNegativeIdx) {
        int beg = 0, end = prevRowFirstNegativeIdx;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            if (grid[r][mid] >= 0) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        return beg;
    }

}