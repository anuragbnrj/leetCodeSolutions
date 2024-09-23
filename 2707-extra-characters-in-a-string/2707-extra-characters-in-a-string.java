class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }

        int len = s.length();
        int[] dp = new int[len + 2];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        int ans = solve(0, s, dict, dp);

        return ans;
    }

    private int solve(int idx, String s, Set<String> dict, int[] dp) {
        if (idx == s.length()) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ans = (int) 1e9;
        String currStr = "";
        for (int i = idx; i < s.length(); i++) {
            currStr += s.charAt(i);
            int temp = (int) 1e9;
            if (dict.contains(currStr)) {
                temp = solve(i + 1, s, dict, dp);
            } else {
                temp = (i - idx + 1) + solve(i + 1, s, dict, dp);
            }

            ans = Math.min(ans, temp);
        }

        dp[idx] = ans;

        return dp[idx];
    }
}