class Solution {
    int[][] dp;
    boolean[][] done;

    public int strangePrinter(String s) {
        int n = s.length();
        char[] sarr = s.toCharArray();
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i > 0 && sarr[i] == sarr[i - 1]) continue;

            sBuilder.append(sarr[i]);
        }
        sarr = sBuilder.toString().toCharArray();
        n = sarr.length;

        done = new boolean[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        int ans = rec(0, n - 1, sarr);

        return ans;
    }

    private int rec(int beg, int end, char[] s) {
        if (beg == end) {
            return 1;
        }

        if (beg > end) {
            return 0;
        }

        if (done[beg][end]) {
            return dp[beg][end];
        }

        int ans = (int) 1e9;
        if (s[beg] == s[end]) {
            ans = Math.min(ans, 1 + rec(beg + 1, end - 1, s));
        }

        ans = Math.min(ans, 1 + rec(beg + 1, end, s));
        ans = Math.min(ans, 1 + rec(beg, end - 1, s));

        // System.out.println("beg: " + beg + ", end: " + end + ", ans: " + ans);
        done[beg][end] = true;
        dp[beg][end] = ans;
        return ans;
    }

}