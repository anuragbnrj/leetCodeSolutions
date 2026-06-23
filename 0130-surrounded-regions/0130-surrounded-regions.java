class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || c == 0 || r == (rows - 1) || c == (cols - 1)) && board[r][c] == 'O') {
                    visited[r][c] = true;
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int r = front[0];
            int c = front[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc, rows, cols) && !visited[nr][nc] && board[nr][nc] == 'O') {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
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