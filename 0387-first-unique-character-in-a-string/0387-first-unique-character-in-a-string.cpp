class Solution {
public:
    int firstUniqChar(string s) {
        int len = s.size();
        map<char, int> mpp;
        
        for (int i = 0; i < len; i++) {
            if (mpp.count(s[i])) {
                mpp[s[i]] += 1;
            } else {
                mpp[s[i]] = 1;
            }
        }

        for (int i = 0; i < len; i++) {
            if (mpp[s[i]] == 1) {
                return i;
            }
        }

        return -1;
    }
};