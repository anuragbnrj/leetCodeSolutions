class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        
        int[][] expanded = new int[3 * n][3 * n];
        for (int r = 0; r < n; r++) {
            char[] sarr = grid[r].toCharArray();
            for (int c = 0; c < n; c++) {
                if (sarr[c] == '/') {
                    int nr = 3 * r;
                    int nc = 3 * c;

                    expanded[nr][nc + 2] = 1;
                    expanded[nr + 1][nc + 1] = 1;
                    expanded[nr + 2][nc] = 1;
                }

                if (sarr[c] == '\\') {
                    int nr = 3 * r;
                    int nc = 3 * c;

                    expanded[nr][nc] = 1;
                    expanded[nr + 1][nc + 1] = 1;
                    expanded[nr + 2][nc + 2] = 1;
                }
            }
        }

        // for (int r = 0; r < 3 * n; r++) {
        //     for (int c = 0; c < 3 * n; c++) {
        //         System.out.print(expanded[r][c] + "\t");
        //     }
        //     System.out.println();
        // }

        boolean[][] visited = new boolean[3 * n][3 * n];
        int ans = 0;
        for (int r = 0; r < 3 * n; r++) {
            for (int c = 0; c < 3 * n; c++) {
                if (expanded[r][c] == 0 && !visited[r][c]) {
                    dfs(r, c, expanded, visited);
                    ans += 1;
                }
            }
        }

        return ans;
    }

    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};

    void dfs(int r, int c, int[][] expanded, boolean[][] visited) {
        int rows = expanded.length;
        int cols = expanded[0].length;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && expanded[nr][nc] == 0) {
                dfs(nr, nc, expanded, visited);
            }
        }
    }

    boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return false;
        }

        return true;
    }
}