class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    islands += 1;
                    dfs(r, c, rows, cols, grid, visited);
                }
            }
        }

        return islands;   
    }

    private void dfs(int r, int c, int rows, int cols, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && grid[nr][nc] == '1') {
                dfs(nr, nc, rows, cols, grid, visited);
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