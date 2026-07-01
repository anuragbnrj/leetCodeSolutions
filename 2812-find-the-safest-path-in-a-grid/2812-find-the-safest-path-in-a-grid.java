class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        final int INF = Integer.MAX_VALUE;

        // Step 1: multi-source BFS from every thief cell to get, for every cell,
        // its distance to the nearest thief. This part was already correct.
        int[][] safety = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> bfsQueue = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    safety[r][c] = 0;
                    visited[r][c] = true;
                    bfsQueue.offer(new int[]{r, c});
                } else {
                    safety[r][c] = INF;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!bfsQueue.isEmpty()) {
            int[] cur = bfsQueue.poll();
            int r = cur[0], c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (isValid(nr, nc, n) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    safety[nr][nc] = safety[r][c] + 1;
                    bfsQueue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: find the path from (0,0) to (n-1,n-1) whose MINIMUM safety
        // value along it is as large as possible ("maximum bottleneck path").
        // Moves are allowed in all 4 directions, so this needs a Dijkstra-style
        // max-priority-queue search over the whole grid — not a right/down-only DP.
        int[][] best = new int[n][n];
        for (int[] row : best) Arrays.fill(row, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap by safety value
        best[0][0] = safety[0][0];
        pq.offer(new int[]{safety[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0], r = cur[1], c = cur[2];

            if (val < best[r][c]) continue; // stale entry, already improved on
            if (r == n - 1 && c == n - 1) return val;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (isValid(nr, nc, n)) {
                    int candidate = Math.min(val, safety[nr][nc]);
                    if (candidate > best[nr][nc]) {
                        best[nr][nc] = candidate;
                        pq.offer(new int[]{candidate, nr, nc});
                    }
                }
            }
        }

        return best[n - 1][n - 1];
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}