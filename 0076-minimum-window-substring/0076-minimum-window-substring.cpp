class Solution {
public:
    string minWindow(string n, string k) {
        vector<int> freqK(256, 0);
        for (char ch : k) {
            freqK[ch]++;
        }

        vector<int> freqN(256, 0);
        int lenN = n.size();
        int minLen = INT_MAX, minBeg, minEnd;
        int beg = 0, end = 0;
        while (end < lenN) {
            freqN[n[end]]++;
            
            
            while (beg <= end && isContained(freqK, freqN)) {
                int currLen = end - beg + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    minBeg = beg;
                    minEnd = end;
                }

                freqN[n[beg]]--;
                beg++;
            }

            end++;
        }

        string res = "";
        for (int i = minBeg; i <= minEnd; i++) {
            res.push_back(n[i]);
        }
        
        return res;
    }

private:
    bool isContained(vector<int> &freqK, vector<int> &freqN) {
        for (int i = 0; i < 256; i++) {
            if (freqK[i] > freqN[i]) {
                return false;
            }
        }
        return true;
    }
};
