class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;

        if (len != (m * n)) {
            return new int[0][0];
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < len; i++) {
            int r = i / n;
            int c = i % n;

            ans[r][c] = original[i];
        }

        return ans;
    }
}