class Solution {
public:
    int characterReplacement(string s, int k) {
        int n = s.size();

        int maxLen = 0;
        map<char, int> freq;
        multiset<int> freqOrder;
        for (int beg = 0, end = 0; end < n; end++) {
            char ch = s[end];
            freq[ch]++;
            freqOrder.insert(freq[ch]);
            if (freqOrder.find(freq[ch] - 1) != freqOrder.end()) {
                freqOrder.erase(freqOrder.find(freq[ch] - 1));
            }

            while (beg <= end && (end - beg + 1) - (*(--freqOrder.end())) > k) {
                char del = s[beg];
                freq[del]--;
                freqOrder.insert(freq[del]);
                freqOrder.erase(freqOrder.find(freq[del] + 1));
                

                if (freq[del] == 0) {
                    freq.erase(del);

                    if (freqOrder.find(0) != freqOrder.end()) {
                        freqOrder.erase(freqOrder.find(0));
                    }
                }

                beg++;
            }

            maxLen = max(maxLen, end - beg + 1);
        }

        return maxLen;
    }
};