class Solution {
public:
    string customSortString(string order, string s) {
        vector<int> freq(26, 0);

        for (char ch : s) {
            freq[ch - 'a']++;
        }

        string res = "";
        for (char ch : order) {
            int cnt = freq[ch - 'a'];

            for (int i = 0; i < cnt; i++) {
                res += ch;
                freq[ch - 'a']--;
            }
        }
        
        for (int i = 0; i < (int) freq.size(); i++) {
            char ch = 'a' + i;
            int cnt = freq[i];

            for (int j = 0; j < cnt; j++) {
                res += ch;
            }
        }

        return res;
    }
};