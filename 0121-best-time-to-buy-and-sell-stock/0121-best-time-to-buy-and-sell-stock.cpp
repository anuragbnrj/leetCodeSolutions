class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();

        int buy = INT_MAX;
        int profit = 0;
        for (int i = 0; i < len; i++) {
            buy = min(buy, prices[i]);

            if (prices[i] > buy) {
                profit = max (profit, prices[i] - buy);
            }
        }

        return profit;
    }
};