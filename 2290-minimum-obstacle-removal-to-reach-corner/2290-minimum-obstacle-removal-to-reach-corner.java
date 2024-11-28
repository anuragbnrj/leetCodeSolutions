class Solution {
    public int minimumObstacles(int[][] grid) {
        return getMinimumObstacles(0, 0, grid.length - 1, grid[0].length - 1, grid);
    }

    private int getMinimumObstacles(int begRow, int begCol, int endRow, int endCol, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a, b) -> {
            return Integer.compare(a.obstaclesRemoved, b.obstaclesRemoved);
        });
        pq.offer(new Cell(0, begRow, begCol));

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while (!pq.isEmpty()) {
            Cell top = pq.poll();
            int row = top.row;
            int col = top.col;
            int removed = top.obstaclesRemoved;

            if (row == endRow && col == endCol) {
                return removed;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (isValid(nr, nc, rows, cols) && !visited[nr][nc]) {
                    pq.offer(new Cell(removed + grid[nr][nc], nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return false;
        }

        return true;
    }


    class Cell {
        int obstaclesRemoved;
        int row;
        int col;

        public Cell(int _obstaclesRemoved, int _row, int _col) {
            obstaclesRemoved = _obstaclesRemoved;
            row = _row;
            col = _col; 
        }
    }
}