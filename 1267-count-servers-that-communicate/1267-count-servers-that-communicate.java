class Solution {
    public int countServers(int[][] grid) {
        HashMap<Integer, Integer> rowCount = new HashMap<>();
        HashMap<Integer, Integer> colCount = new HashMap<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int row = r;
                    int rowVal = rowCount.getOrDefault(row, 0);
                    rowCount.put(row, rowVal + 1);

                    int col = c;
                    int colVal = colCount.getOrDefault(col, 0);
                    colCount.put(col, colVal + 1);
                }
            }
        }

        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int row = r;
                    int rowVal = rowCount.get(row);

                    int col = c;
                    int colVal = colCount.get(col);

                    if (rowVal > 1 || colVal > 1) {
                        ans += 1;
                    }
                }
            }
        }

        return ans;
    }
}