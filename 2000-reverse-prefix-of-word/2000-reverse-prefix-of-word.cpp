class Solution {
public:
    string reversePrefix(string word, char ch) {
        bool done = false;

        string res = "";

        for (char curr : word) {
            if (curr == ch) {
                res += ch;
                if (!done) {
                    reverse(res.begin(), res.end());
                    done = true;
                }
            } else {
                res += curr;
            }
        } 

        return res;
        
    }
};