class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] time = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    time[r][c] = 0;
                    visited[r][c] = true;
                    q.offer(new int[]{r, c, 0});
                }
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while (!q.isEmpty()) {
            int[] front = q.poll();

            int r = front[0];
            int c = front[1];
            int dist = front[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && grid[nr][nc] == 1) {
                    time[nr][nc] = dist + 1;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (time[r][c] == 0) {
                        return -1;
                    }

                    ans = Math.max(ans, time[r][c]);
                }
            }
        }

        return ans;
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        return true;
    }
}