class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] gridNumber = new int[rows][cols];
        int islandNumber = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    islandNumber += 1;
                    dfs(r, c, rows, cols, grid, visited, gridNumber, islandNumber);
                }
            }
        }

        int[] gridArea = new int[islandNumber + 1];
        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 0) {
                    gridArea[gridNumber[r][c]] += 1;
                    ans = Math.max(ans, gridArea[gridNumber[r][c]]);
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, int rows, int cols, int[][] grid, boolean[][] visited, int[][] gridNumber, int islandNumber) {
        visited[r][c] = true;
        gridNumber[r][c] = islandNumber;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && grid[nr][nc] == 1) {
                dfs(nr, nc, rows, cols, grid, visited, gridNumber, islandNumber);
            }
        } 
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return false;
        }

        return true;
    }
}