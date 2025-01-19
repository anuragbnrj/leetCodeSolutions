class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;

        if (rows < 3 || cols < 3) return 0;

        int[][] limit = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            Arrays.fill(limit[r], (int) 1e9);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int c = 0; c < cols; c++) {
            pq.offer(new int[]{heightMap[0][c], 0, c});
            pq.offer(new int[]{heightMap[rows - 1][c], rows - 1, c});
            limit[0][c] = heightMap[0][c];
            limit[rows - 1][c] = heightMap[rows - 1][c];
        }
        for (int r = 1; r < rows - 1; r++) {
            pq.offer(new int[]{heightMap[r][0], r, 0});
            pq.offer(new int[]{heightMap[r][cols - 1], r, cols - 1});
            limit[r][0] = heightMap[r][0];
            limit[r][cols - 1] = heightMap[r][cols - 1];
        }

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int currLimit = top[0];
            int r = top[1];
            int c = top[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newLimit = Math.max(currLimit, heightMap[nr][nc]);
                    if (newLimit < limit[nr][nc]) {
                        pq.offer(new int[]{newLimit, nr, nc});
                        limit[nr][nc] = newLimit;
                    }
                }
            }
        }

        int ans = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (limit[r][c] > heightMap[r][c]) {
                    ans += limit[r][c] - heightMap[r][c];
                }
            }
        }

        return ans;
    }
}
