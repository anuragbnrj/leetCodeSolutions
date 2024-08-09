class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int ans = 0;
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                HashSet<Integer> occurred = new HashSet<>();
                HashSet<Integer> distinct = new HashSet<>();

                int mainDiagSum = 0;
                int altDiagSum = 0;
                for (int i = r; i < r + 3 && i < rows; i++) {
                    int rowSum = 0;
                    for (int j = c; j < c + 3 && j < cols; j++) {
                        if (grid[i][j] >= 1 && grid[i][j] <= 9) {
                            distinct.add(grid[i][j]);
                        }
                        
                        rowSum += grid[i][j];

                        if (i - r == j - c) {
                            mainDiagSum += grid[i][j];
                        }

                        if (((i - r) + (j - c)) == 2) {
                            altDiagSum += grid[i][j];
                        }
                    }

                    occurred.add(rowSum);
                }

                occurred.add(mainDiagSum);
                occurred.add(altDiagSum);

                for (int j = c; j < c + 3 && j < cols; j++) {
                    int colSum = 0;
                    for (int i = r; i < r + 3 && i < rows; i++) {
                        colSum += grid[i][j];
                    }

                    occurred.add(colSum);
                }

                // System.out.println("occurred.size(): " + occurred.size() + ", distinct.size(): " + distinct.size());
                if (occurred.size() == 1 && distinct.size() == 9) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}