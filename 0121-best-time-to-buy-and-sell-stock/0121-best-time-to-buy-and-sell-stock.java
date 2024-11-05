class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        int minTillNow = (int) 1e9;
        for (int curr : prices) {
            if (curr > minTillNow) {
                ans = Math.max(ans, curr - minTillNow);
            }

            minTillNow = Math.min(minTillNow, curr);
        }

        return ans;
    }
}