class Solution {
public:
    int longestIdealString(string s, int k) {
        int n = s.size();

        vector<int> maxLen(26, 0);
        int res = INT_MIN;
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            int idx = ch - 'a';

            int beg = max(0, idx - k);
            int end = min(25, idx + k);
            int temp = INT_MIN;
            for (int j = beg; j <= end; j++) {
                temp = max(temp, 1 + maxLen[j]);
            }

            maxLen[idx] = temp;
            res = max(res, maxLen[idx]);
        }

        // for (int i = 0; i < 26; i++) {
        //     cout << maxLen[i] << ", ";
        // }
        // cout << endl;

        return res;
    }
};