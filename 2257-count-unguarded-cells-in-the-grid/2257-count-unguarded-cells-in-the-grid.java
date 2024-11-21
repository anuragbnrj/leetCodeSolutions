class Solution {
    public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
        int[][] grid = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int[] wall : walls) {
            int row = wall[0];
            int col = wall[1];
            grid[row][col] = 1;
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            if (visited[row][col] == true) continue;

            for (int c = col; c >= 0; c--) {
                if (grid[row][c] == 1) break;

                grid[row][c] = 2;
                visited[row][c] = true;
            }

            for (int c = col; c < cols; c++) {
                if (grid[row][c] == 1) break;

                grid[row][c] = 2;
                visited[row][c] = true;
            }
        }

        visited = new boolean[rows][cols];
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            if (visited[row][col] == true) continue;

            for (int r = row; r >= 0; r--) {
                if (grid[r][col] == 1) break;

                grid[r][col] = 2;
                visited[r][col] = true;
            }

             for (int r = row; r < rows; r++) {
                if (grid[r][col] == 1) break;

                grid[r][col] = 2;
                visited[r][col] = true;
            }
        }

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    ans += 1;
                }
            }
        }

        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
        //         System.out.print(grid[r][c] + "\t");
        //     }
        //     System.out.println();
        // }

        return ans;
    }
}