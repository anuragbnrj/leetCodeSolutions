class Solution {
public:
    int firstUniqChar(string s) {
        int len = s.size();
        unordered_map<char, int> mpp;
        
        for (int i = 0; i < len; i++) {
            mpp[s[i]] += 1;
        }

        for (int i = 0; i < len; i++) {
            if (mpp[s[i]] == 1) {
                return i;
            }
        }

        return -1;
    }
};