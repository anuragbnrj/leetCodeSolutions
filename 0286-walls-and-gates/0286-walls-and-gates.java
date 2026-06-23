class Solution {
    private static final int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    q.offer(new int[]{r, c, 0});
                    visited[r][c] = true;
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

                if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && rooms[nr][nc] != -1) {
                    if (rooms[nr][nc] == INF) {
                        rooms[nr][nc] = dist + 1;
                    }

                    q.offer(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
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