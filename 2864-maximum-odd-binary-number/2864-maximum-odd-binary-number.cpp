class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int ze = 0, on = 0;
        
        for (auto ch : s) {
            if (ch == '0') {
                ze++;
            } else {
                on++;
            }
        }
        
        string res = "";
        for (int i = 1; i <= on - 1; i++) {
            res += "1";
        }
        
        for (int i = 1; i <= ze; i++) {
            res += "0";
        }
        
        res += "1";
        
        return res;
        
    }
};