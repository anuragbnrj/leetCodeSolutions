class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int r = 0; r < s1.length(); r++) {
            Arrays.fill(memo[r], -1);
        }

        return rec(0, 0, s1, s2, memo);
    }

    private int rec(int idx1, int idx2, String s1, String s2, int[][] memo) {
        if (idx1 == s1.length() && idx2 == s2.length()) {
            return 0;
        }

        if (idx1 == s1.length()) {
            return (int) s2.charAt(idx2) + rec(idx1, idx2 + 1, s1, s2, memo);
        }

        if (idx2 == s2.length()) {
            return (int) s1.charAt(idx1) + rec(idx1 + 1, idx2, s1, s2, memo);
        }

        if (memo[idx1][idx2] != -1) {
            return memo[idx1][idx2];
        }

        int ans = Integer.MAX_VALUE;
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            ans = rec(idx1 + 1, idx2 + 1, s1, s2, memo);
        }

        int path1 = (int) s1.charAt(idx1) + rec(idx1 + 1, idx2, s1, s2, memo);
        int path2 = (int) s2.charAt(idx2) + rec(idx1, idx2 + 1, s1, s2, memo);
    
        ans = Math.min(ans, Math.min(path1, path2));

        memo[idx1][idx2] = ans;

        return ans;
    }
}