class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] ans = new int[rows][cols];
        Queue<Location> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isWater[r][c] == 1) {
                    q.offer(new Location(r, c));
                    ans[r][c] = 0;
                } else {
                    ans[r][c] = -1;
                }
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while(!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < q.size(); i++) {
                Location front = q.poll();
                int currRow = front.row;
                int currCol = front.col;

                for (int j = 0; j < 4; j++) {
                    int nr = currRow + dr[j];
                    int nc = currCol + dc[j];

                    if (isValid(nr, nc, rows, cols) && ans[nr][nc] == -1) {
                        q.offer(new Location(nr, nc));
                        ans[nr][nc] = ans[currRow][currCol] + 1;
                    }
                }
            }
        }

        return ans;
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || rows <= nr || nc < 0 || cols <= nc) {
            return false;
        }
        return true;
    }

    class Location {
        int row;
        int col;

        public Location(int _row, int _col) {
            row = _row;
            col = _col;
        }
    }
}