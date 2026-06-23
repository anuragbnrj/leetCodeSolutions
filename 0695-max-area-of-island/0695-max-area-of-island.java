class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    int area = bfs(grid, r, c, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }

    private int bfs(int[][] grid, int r, int c, boolean[][] visited) {
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        int area = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        area += 1;

        while (!q.isEmpty()) {
            int[] front = q.poll();

            int row = front[0];
            int col = front[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (isValid(nr, nc, grid.length, grid[0].length) && !visited[nr][nc] && grid[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    area += 1;
                }
            }
        }

        return area;
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        return true;
    }
}