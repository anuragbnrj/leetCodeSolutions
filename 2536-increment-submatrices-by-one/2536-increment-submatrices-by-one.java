class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] psum = new int[n + 2][n + 2];

        for (int[] query : queries) {
            int r1 = query[0] + 1;
            int c1 = query[1] + 1;
            int r2 = query[2] + 1;
            int c2 = query[3] + 1;

            psum[r1][c1] += 1;
            psum[r1][c2 + 1] -= 1;
            psum[r2 + 1][c1] -= 1;
            psum[r2 + 1][c2 + 1] += 1;
        }

        int[][] ans = new int[n][n];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                psum[r][c] = psum[r][c] + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];
                ans[r - 1][c - 1] = psum[r][c];
            }
        }
        
        return ans;
    }
}