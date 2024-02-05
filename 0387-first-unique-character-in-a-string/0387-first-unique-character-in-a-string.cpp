class Solution {
public:
    int firstUniqChar(string s) {
        int len = s.size();

        vector<int> idx(26, -1);
        for (int i = 0; i < len; i++) {
            char ch = s[i];

            if (idx[ch - 'a'] > -1) {
                idx[ch - 'a'] = INT_MAX;
            } else {
                idx[ch - 'a'] = i;
            }
        }

        int res = INT_MAX;
        for (int i = 0; i < 26; i++) {
            if (idx[i] != -1) {
                res = min(res, idx[i]);
            }
        }

        if (res == INT_MAX) {
            res = -1;
        } 

        return res;
        
    }
};