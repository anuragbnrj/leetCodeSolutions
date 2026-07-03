class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] path = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            Arrays.fill(path[r], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[2], b[2]);
        });
        pq.offer(new int[]{0, 0, grid.get(0).get(0)});
        path[0][0] = grid.get(0).get(0);

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int shortestPath = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int[] top = pq.poll();

            int r = top[0];
            int c = top[1];
            int deduction = top[2];

            if (r == rows - 1 && c == cols - 1) {
                shortestPath = deduction;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc, rows, cols) && deduction + grid.get(nr).get(nc) < path[nr][nc]) {
                    pq.offer(new int[]{nr, nc, deduction + grid.get(nr).get(nc)});
                    path[nr][nc] = deduction + grid.get(nr).get(nc);
                }
            }
        }

        // System.out.println("shortestPath: " + shortestPath);

        return ((health - shortestPath) >= 1);
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return (0 <= r && r < rows && 0 <= c && c < cols);
    }
}