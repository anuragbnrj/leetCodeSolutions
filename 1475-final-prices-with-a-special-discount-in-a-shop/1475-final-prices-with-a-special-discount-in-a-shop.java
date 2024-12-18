class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int curr = prices[i];
            int disc = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= curr) {
                    disc = prices[j];
                    break;
                }
            }

            ans[i] = curr - disc;
        }

        return ans;
    }
}