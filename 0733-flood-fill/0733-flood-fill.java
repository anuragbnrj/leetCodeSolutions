class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        
        int begCol = image[sr][sc];
        boolean[][] visited = new boolean[rows][cols];

        dfs(sr, sc, rows, cols, image, visited, begCol, color);

        return image;
    }

    private void dfs(int r, int c, int rows, int cols, int[][] image, boolean[][] visited, int begCol, int targetCol) {
        visited[r][c] = true;
        image[r][c] = targetCol;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && image[nr][nc] == begCol) {
                dfs(nr, nc, rows, cols, image, visited, begCol, targetCol);
            }
        }
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        return true;
    }
}