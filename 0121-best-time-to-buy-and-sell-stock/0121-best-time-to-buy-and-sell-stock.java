class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int res = 0;
        int mn = prices[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, prices[i] - mn);

            mn = Math.min(mn, prices[i]);
        }

        return res;
    }
}