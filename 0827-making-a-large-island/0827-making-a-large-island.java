class Solution {

    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};

    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = rows;

        int[][] parent = new int[rows][cols];
        Map<Integer, Integer> componentSize = new HashMap<>();

        int componentCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && parent[r][c] == 0) {
                    componentCount += 1;

                    componentSize.put(componentCount, 0);
                    dfs(r, c, grid, parent, componentSize, componentCount, rows, cols);
                }
            }
        }

        System.out.println(componentSize.toString());

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    int temp = 0;
                    Set<Integer> used = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (isValid(nr, nc, rows, cols) && grid[nr][nc] == 1 && !used.contains(parent[nr][nc])) {
                            temp += componentSize.get(parent[nr][nc]);
                            used.add(parent[nr][nc]);
                        }
                    }

                    temp += 1;
                    ans = Math.max(ans, temp);
                } else {
                    ans = Math.max(ans, componentSize.get(parent[r][c]));
                } 
            }
        }

        return ans;
    }

    private void dfs(int r, int c, int[][] grid, int[][] parent, Map<Integer, Integer> componentSize, int componentNumber, int rows, int cols) {
        parent[r][c] = componentNumber;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isValid(nr, nc, rows, cols) && grid[nr][nc] == 1 && parent[nr][nc] == 0) {
                dfs(nr, nc, grid, parent, componentSize, componentNumber, rows, cols);
            }
        }

        componentSize.put(componentNumber, componentSize.get(componentNumber) + 1);
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        return (0 <= nr && nr < rows && 0 <= nc && nc < cols);
    }
}