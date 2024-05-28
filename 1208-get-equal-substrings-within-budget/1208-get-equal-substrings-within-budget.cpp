class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n = s.size();

        vector<int> cost(n);
        for (int i = 0; i < n; i++) {
            cost[i] = abs(s[i] - t[i]);
        }

        int currCost = 0;
        int res = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            currCost += cost[end];

            while (currCost > maxCost && beg <= end) {
                currCost -= cost[beg];
                beg++;
            }

            if (end - beg + 1 > 0) {
                res = max(res, (end - beg + 1));
            }
        }

        return res;
    }
};