class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int len = prices.length;
        long profitNoStrategy = 0;
        long prevKProduct = 0;
        long prevKBy2PricesSum = 0;
        long maxProfitDelta = 0;
        for (int i = 0; i < len; i++) {
            profitNoStrategy += prices[i] * strategy[i];
            prevKProduct += prices[i] * strategy[i];
            prevKBy2PricesSum += prices[i];

            if (i >= k) prevKProduct -= prices[i - k] * strategy[i - k];
            if (i >= (k / 2)) prevKBy2PricesSum -= prices[i - (k / 2)];

            if (i >= (k - 1)) {
                long currProfitDelta = prevKBy2PricesSum - prevKProduct;
                maxProfitDelta = Math.max(maxProfitDelta, currProfitDelta);
            }
        }

        return Math.max(profitNoStrategy, profitNoStrategy + maxProfitDelta);
    }
}