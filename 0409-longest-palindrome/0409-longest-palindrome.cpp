class Solution {
public:
    int longestPalindrome(string s) {
        map<char, int> freq;

        for (char ch : s) {
            freq[ch]++;
        }

        int res = 0;
        bool oddPresent = false;
        for (auto el : freq) {
            int count = el.second;

            if (count % 2 == 0) {
                res += count;
            } else {
                res += count - 1;
                oddPresent = true;
            }
        }

        if (oddPresent) {
            res += 1;
        }

        return res;
    }
};