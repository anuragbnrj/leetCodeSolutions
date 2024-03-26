class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int len = s.size();

        map<char, int> freq;
        int mxLen = 0;
        for (int beg = 0, end = 0; end < len; end++) {
            char ch = s[end];

            freq[ch]++;

            while (freq[ch] > 1) {
                char rm_ch = s[beg];
                freq[rm_ch]--;
                beg++;
            }

            mxLen = max(mxLen, end - beg + 1);
        }

        return mxLen;
        
    }
};