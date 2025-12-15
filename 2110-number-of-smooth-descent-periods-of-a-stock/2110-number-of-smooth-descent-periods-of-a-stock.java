class Solution {
    public long getDescentPeriods(int[] prices) {
        int len = prices.length;

        long ans = 0;
        int currLen = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && (prices[i - 1] - prices[i] == 1)) {
                currLen += 1;
            } else {
                currLen = 1;
            }

            ans += currLen;
        }

        return ans;
    }
}