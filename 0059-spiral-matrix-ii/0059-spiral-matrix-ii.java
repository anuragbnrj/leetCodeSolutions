class Solution {
    public int[][] generateMatrix(int n) {
        int rows = n;
        int cols = n;
        int[][] ans = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        int filled = 0;
        ans[0][0] = 1;
        visited[0][0] = true;
        filled = 1;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;
        int r = 0, c = 0;
        
        while (filled < (rows * cols)) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // System.out.println("r: " + r + ", c: " + c + ", nr: " + nr + ", nc: " + nc + ", dir: " + dir);

            if (!isValid(nr, nc, rows, cols) || visited[nr][nc] == true) {
                dir = (dir + 1) % 4;
            } else {
                filled += 1;
                ans[nr][nc] = filled;
                visited[nr][nc] = true;

                r = nr;
                c = nc;
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