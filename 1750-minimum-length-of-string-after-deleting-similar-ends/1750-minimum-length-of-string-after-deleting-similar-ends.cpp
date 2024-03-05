class Solution {
public:
    int minimumLength(string s) {
        int len = s.size();
        int beg = 0;
        int end = len - 1;

        while (beg < end) {
            char chbeg = s[beg];
            char chend = s[end];

            if (chbeg != chend) {
                break;
            }

            while (beg <= end && s[beg] == chbeg) {
                beg++;
            }

            while (beg <= end && s[end] == chend) {
                end--;
            }
        }

        if (beg > end) {
            return 0;
        } else {
            return end - beg + 1;
        }
        
    }
};