class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        Map<Integer, Integer> fishes = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] > 0) {
                    count += 1;
                    fishes.put(count, 0);
                    dfs(r, c, rows, cols, grid, visited, count, fishes);
                }
            }
        }

        int ans = 0;
        for (Integer value : fishes.values()) {
            ans = Math.max(ans, value);
        }

        return ans;
    }

    private void dfs(int r, int c, int rows, int cols, int[][] grid, boolean[][] visited, int count, Map<Integer, Integer> fishes) {
        visited[r][c] = true;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && grid[nr][nc] > 0 && !visited[nr][nc]) {
                dfs(nr, nc, rows, cols, grid, visited, count, fishes);
            }
        }

        fishes.put(count, fishes.get(count) + grid[r][c]);
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        return 0 <= nr && nr < rows && 0 <= nc && nc < cols;
    }
}