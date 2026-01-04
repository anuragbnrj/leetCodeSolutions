class Solution {
    private final int MOD = (int) 1e9 + 7;

    private final int[][] possibilities = {
        // 0: no previous row
        { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },

        // 1: RYR
        { 2, 3, 5, 6, 11 },

        // 2: YRY
        { 1, 4, 7, 9, 12 },

        // 3: GRY
        { 1, 4, 7, 8 },

        // 4: RYG
        { 2, 3, 8, 11 },

        // 5: YRG
        { 1, 7, 9, 10 },

        // 6: GRG
        { 1, 7, 8, 10, 11 },

        // 7: RGR
        { 2, 3, 5, 6, 12 },

        // 8: YGR
        { 3, 4, 6, 12 },

        // 9: GYR
        { 2, 5, 10, 11 },

        // 10: RGY
        { 5, 6, 9, 12 },

        // 11: YGY
        { 1, 4, 6, 9, 12 },

        // 12: GYG
        { 2, 7, 8, 10, 11 }
    };

    public int numOfWays(int n) {
        int[][] memo = new int[n + 1][13];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        return rec(n, 0, memo);
    }


    private int rec(int left, int prev, int[][] memo) {
        if (left == 0) {
            return 1;
        }

        if (memo[left][prev] != -1) {
            return memo[left][prev];
        }

        int ans = 0;
        for (int possibility : possibilities[prev]) {
            ans = (ans + rec(left - 1, possibility, memo)) % MOD;
        }

        memo[left][prev] = ans;
        return memo[left][prev];
    }
}