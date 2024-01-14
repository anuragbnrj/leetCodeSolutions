class Solution {
public:
    bool closeStrings(string word1, string word2) {
        int len1 = word1.size();
        int len2 = word2.size();

        if (len1 != len2) {
            return false;
        }
        
        vector<int> freq1(26, 0);
        for (char ch : word1) {
            freq1[ch - 'a']++;
        }

        vector<int> freq2(26, 0);
        for (char ch : word2) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(freq1[i] > 0 && freq2[i] == 0) {
                return false;
            }

            if (freq1[i] == 0 && freq2[i] > 0) {
                return false;
            }
        }

        map<int, int> freqCount1;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) {
                freqCount1[freq1[i]]++;
            }
        }

        map<int, int> freqCount2;
        for (int i = 0; i < 26; i++) {
            if (freq2[i] > 0) {
                freqCount2[freq2[i]]++;
            }
        }

        return (freqCount1 == freqCount2);
    }
};