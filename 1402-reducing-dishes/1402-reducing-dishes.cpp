class Solution {
public:
    int maxSatisfaction(vector<int>& s) {
        int n = s.size();
        sort(s.begin(), s.end());

        int mx = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i, time = 1; j < n; j++, time++) {
                curr += (time * s[j]);
            }
            mx = max(mx, curr);
        }

        return mx;
    }
};