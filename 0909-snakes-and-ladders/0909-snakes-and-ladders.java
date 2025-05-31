class Solution {
    public int snakesAndLadders(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[] jumpTo = new int[rows * cols];
        Arrays.fill(jumpTo, -1);
        boolean rev = false;
        int idx = 0;
        for (int r = rows - 1; r >= 0; r--, rev = !rev) {
            if (rev) {
                for (int c = cols - 1; c >= 0; c--, idx++) {
                    if (board[r][c] != -1) {
                        jumpTo[idx] = board[r][c] - 1;
                    }
                }
            } else {
                for (int c = 0; c < cols; c++, idx++) {
                    if (board[r][c] != -1) {
                        jumpTo[idx] = board[r][c] - 1;
                    }
                }
            }
        }

        boolean[] visited = new boolean[rows * cols];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int ans = -1;
        int iter = 0;
        while (!q.isEmpty() && ans == -1) {
            int sz = q.size();

            iter += 1;

            for (int i = 0; i < sz && ans == -1; i++) {
                int front = q.poll();

                for (int roll = 1; roll <= 6; roll++) {
                    int next = front + roll;

                    if (next >= rows * cols) break;

                    if (jumpTo[next] != -1) next = jumpTo[next];

                    if (next == (rows * cols - 1)) ans = iter;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return ans;
    }
}