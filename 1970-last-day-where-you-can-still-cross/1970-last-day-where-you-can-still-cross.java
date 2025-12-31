class Solution {
    public int latestDayToCross(int rows, int cols, int[][] cells) {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < cells.length; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = i + 1;
        }

        int beg = 1;
        int end = (int) 1e9 + 7;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (isPossible(grid, mid))
                beg = mid + 1;
            else
                end = mid;
        }

        return beg - 1;
    }

    // Multi-source BFS from all land cells in the top row
    private boolean isPossible(int[][] grid, int day) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        // Initialize queue with all land cells in the top row
        for (int c = 0; c < n; c++) {
            if ((grid[0][c] == 0 || grid[0][c] > day)) {
                visited[0][c] = true;
                q.offer(new int[] { 0, c });
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            // Reached bottom row
            if (r == m - 1)
                return true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                if (visited[nr][nc])
                    continue;

                // Can move only to land cells
                if (grid[nr][nc] == 0 || grid[nr][nc] > day) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }
}