class Solution {
public:
    int minimumLength(string s) {
        int len = s.size();
        int beg = 0;
        int end = len - 1;

        while (beg < end && s[beg] == s[end]) {
            char ch = s[beg];

            while (beg <= end && s[beg] == ch) {
                beg++;
            }

            while (beg < end && s[end] == ch) {
                end--;
            }
        }

        return end - beg + 1;   
    }
};