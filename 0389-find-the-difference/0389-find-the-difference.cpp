class Solution {
public:
    char findTheDifference(string s, string t) {
        int xorr = 0;

        for (char ch : s) {
            xorr = xorr ^ (ch - 'a');
        }

        char res;
        for (char ch : t) {
            xorr = xorr ^ (ch - 'a');
        }

        // cout << "xor: " << xorr << endl;
        
        res = xorr + 'a';
        return res;
        
    }
};