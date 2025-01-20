class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        HashMap<Integer, Location> position = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                position.put(mat[r][c], new Location(r, c));
            }
        }

        int[] rowCounts = new int[rows];
        int[] colCounts = new int[cols];
        for (int i = 0; i < rows * cols; i++) {
            int curr = arr[i];

            Location loc = position.get(curr);
            int row = loc.row;
            int col = loc.col;

            rowCounts[row] += 1;
            if (rowCounts[row] == cols) {
                return i;
            }

            colCounts[col] += 1;
            if (colCounts[col] == rows) {
                return i;
            }
        }

        return -1;
    }

    private class Location {
        int row;
        int col;

        public Location(int _row, int _col) {
            row = _row;
            col = _col;
        }
    }
}