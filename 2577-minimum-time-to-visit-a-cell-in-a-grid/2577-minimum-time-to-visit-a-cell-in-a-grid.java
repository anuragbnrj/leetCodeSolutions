class Solution {
    public int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.dist, b.dist);
        });
        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int ans = -1;
        while (!pq.isEmpty()) {
            Point top = pq.poll();
            int currDist = top.dist;
            int currRow = top.r;
            int currCol = top.c;

            // System.out.println("currRow: " + currRow + ", currCol: " + currCol + ", currDist: " + currDist);

            if (currRow == (rows - 1) && currCol == (cols - 1)) {
                ans = currDist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = currRow + dr[i];
                int nc = currCol + dc[i];

                if (isValid(nr, nc, rows, cols) && !visited[nr][nc]) {
                    int temp = currDist;

                    if (temp + 1 >= grid[nr][nc]) {
                        // System.out.println("\t 1. nr: " + nr + ", nc: " + nc + ", dist: " + (temp + 1));
                        pq.offer(new Point(temp + 1, nr, nc));
                        visited[nr][nc] = true;
                    } else {
                        while (temp + 1 < grid[nr][nc]) {
                            temp += 2;
                        }
                        temp = temp + 1;

                        // System.out.println("\t 2. nr: " + nr + ", nc: " + nc + ", dist: " + temp);
                        pq.offer(new Point(temp, nr, nc));
                        visited[nr][nc] = true; 
                    }
                }
            }
        }

        return ans;
    }

    boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return false;
        }

        return true;
    }

    class Point {
        int dist;
        int r; 
        int c;

        public Point(int _dist, int _r, int _c) {
            dist = _dist;
            r = _r;
            c = _c;
        }
    }
}