class Solution {
    public int INF = 1_000_000_000;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        int ans = solve(0, books, shelfWidth, dp);

        return ans;
    }

    private int solve(int idx, int[][] books, int shelfWidth, int[] dp) {
        int n = books.length;

        if (idx == n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ans = INF;
        int currWidth = 0;
        int maxHeight = 0;
        for (int i = idx; i < n; i++) {
            if ((currWidth + books[i][0]) <= shelfWidth) {
                currWidth += books[i][0];
                maxHeight = Math.max(maxHeight, books[i][1]);

                int temp = maxHeight + solve(i + 1, books, shelfWidth, dp);

                if (temp < ans) {
                    ans = temp;
                }
                
            } else {
                break;
            }
        }

        dp[idx] = ans;

        return ans;
    }
}