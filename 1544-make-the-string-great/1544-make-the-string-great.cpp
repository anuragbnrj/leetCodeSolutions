class Solution {
public:
    string makeGood(string s) {
        int n = s.size();

        string res;
        for (int i = 0; i < n; i++) {
            
            if (i + 1 < n) {
                
                char next = s[i + 1];

                if ((s[i] + 32 == s[i + 1]) || (s[i] - 32 == s[i + 1])) {
                    i++;
                } else {
                    res += curr;
                }
            } else {
                res += 
            }
            
        }

        return res;
    }
};