class Solution {
public:
    int minSteps(string s, string t) {
        vector<int> freq(26, 0);

        for (char ch : s) {
            freq[ch - 'a'] += 1;
        }

        for (char ch : t) {
            freq[ch - 'a'] -= 1;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                res += freq[i];
            }
        }

        return res;
    }
};