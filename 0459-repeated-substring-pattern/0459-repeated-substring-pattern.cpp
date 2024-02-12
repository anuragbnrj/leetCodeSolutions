class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int len = s.size();

        string sub = "";

        for (int i = 0; i < len - 1; i++) {
            sub += s[i];
            string temp = "";
            while ((int)temp.size() < len) {
                temp += sub;
            }

            if (temp == s) {
                // cout << "i: " << i << " temp: " << temp << endl;
                return true;
            }
        }

        return false;
        
    }
};