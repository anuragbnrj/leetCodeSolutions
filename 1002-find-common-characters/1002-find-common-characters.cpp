class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        int n = words.size();
        
        vector<int> freq(26, 1e9);
        for (string word : words) {
            vector<int> currFreq(26, 0);
            for (char ch : word) {
                currFreq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                freq[i] = min(freq[i], currFreq[i]);
            }
        }

        vector<string> res;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                for (int j = 0; j < freq[i]; j++) {
                    string temp(1, 'a' + i);
                    res.push_back(temp);
                }
            }
        }

        return res;
    }
};