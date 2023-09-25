class Solution {
public:
    char findTheDifference(string s, string t) {
        map<char, int> mpp;

        for (char ch : s) {
            if (!mpp.count(ch)) {
                mpp[ch] = 1;
            } else {
                mpp[ch] += 1;
            }
        }

        char res;
        for (char ch : t) {
            mpp[ch] -= 1;

            if (!mpp.count(ch) || mpp[ch] < 0) {
                res = ch;
            }
        }

        
        return res;
        
    }
};