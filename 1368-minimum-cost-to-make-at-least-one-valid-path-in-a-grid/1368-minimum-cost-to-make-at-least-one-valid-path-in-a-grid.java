class Solution {
    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] cost = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cost[r][c] = (int) 1e9;
            }
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });
        pq.offer(new Cell(0, 0, 0));
        cost[0][0] = 0;

        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, 1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Cell top = pq.poll();

            int currCost = top.cost;
            int row = top.row;
            int col = top.col; 

            for (int i = 1; i <= 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (isValid(nr, nc, rows, cols)) {
                    if (grid[row][col] == i) {
                        if (currCost < cost[nr][nc]) {
                            pq.offer(new Cell(currCost, nr, nc));
                            cost[nr][nc] = currCost;
                        }
                    } else {
                        if (currCost + 1 < cost[nr][nc]) {
                            pq.offer(new Cell(currCost + 1, nr, nc));
                            cost[nr][nc] = currCost + 1;
                        }
                        
                    }
                }
            }
        }

        return cost[rows - 1][cols - 1];
    }

    private boolean isValid(int nr, int nc, int rows, int cols) {
        if (nr < 0 || rows <= nr || nc < 0 || cols <= nc) {
            return false;
        }
        return true;
    }

    class Cell {
        int cost;
        int row;
        int col;

        public Cell(int _cost, int _row, int _col) {
            cost = _cost;
            row = _row;
            col = _col;
        }
    }
}