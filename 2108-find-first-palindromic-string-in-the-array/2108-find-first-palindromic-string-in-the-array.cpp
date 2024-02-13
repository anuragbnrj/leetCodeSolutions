class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        string res = "";

        for (auto word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return res;
    }

private:
    bool isPalindrome(string s) {
        int len = s.size();

        int beg = 0, end = len - 1;
        while (beg <= end) {
            if (s[beg] != s[end]) {
                return false;
            }
            beg++;
            end--;
        }

        return true;
    }
};