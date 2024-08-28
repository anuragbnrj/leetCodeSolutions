class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid2[r][c] == 1) {
                    boolean isSub = isSubIsland(r, c, rows, cols, visited, grid1, grid2);

                    if (isSub) {
                        ans += 1;
                    }
                }
            }
        }

        return ans; 
    }

    private boolean isSubIsland(int r, int c, int rows, int cols, boolean[][] visited, int[][] grid1, int[][] grid2) {
        visited[r][c] = true;

        boolean ans;
        if (grid1[r][c] == 1) {
            ans = true;
        } else {
            ans = false;
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && grid2[nr][nc] == 1) {
                ans = isSubIsland(nr, nc, rows, cols, visited, grid1, grid2) && ans;
            }
        }

        return ans;
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return false;
        }

        return true;
    }
}