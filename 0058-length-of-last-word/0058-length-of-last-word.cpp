class Solution {
public:
    int lengthOfLastWord(string s) {
        int n = s.size();

        string word = "";
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') {
                word = "";
            } else {
                word += s[i];
                res = word.size();
            }
        }

        return res; 
    }
};