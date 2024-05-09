class Solution {
public:
    long long maximumHappinessSum(vector<int>& h, int k) {
        sort(h.begin(), h.end());
        reverse(h.begin(), h.end());
        
        long long res = 0;
        for (int i = 0; i < k; i++) {
            res = res + max((h[i] - i), 0);
        }
        
        return res;
    }
};