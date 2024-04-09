class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int res = 0;

        int required = tickets[k];
        for (int i = 0; i < tickets.size(); i++) {
            int curr = tickets[i];

            if (i <= k) {
                res += min(curr, required);
            } else {
                res += min(curr, required - 1);
            }
            
        }

        return res;
    }
};