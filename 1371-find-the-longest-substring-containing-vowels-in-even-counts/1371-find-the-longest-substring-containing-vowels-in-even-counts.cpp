class Solution {
public:
    int findTheLongestSubstring(string s) {
        int n = s.size();

        map<char, int> mpp;
        mpp['a'] = 0;
        mpp['e'] = 1;
        mpp['i'] = 2;
        mpp['o'] = 3;
        mpp['u'] = 4;

        set<char> vowels = {'a', 'e', 'i', 'o', 'u'};

        int xr = 0;
        int res = 0;
        map<int, int> prevLocation;
        prevLocation[0] = -1;
        for (int i = 0; i < n; i++) {
            char ch = s[i];

            if (vowels.find(ch) != vowels.end()) {
                xr = xr ^ (1 << mpp[ch]);
            }

            if (prevLocation.find(xr) != prevLocation.end()) {
                res = max(res, i - prevLocation[xr]);
            } else {
                prevLocation[xr] = i;
            }
            
        }

        return res;
    }
};