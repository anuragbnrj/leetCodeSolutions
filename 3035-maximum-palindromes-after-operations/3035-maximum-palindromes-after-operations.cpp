class Solution {
public:
    int maxPalindromesAfterOperations(vector<string>& words) {
        int len = words.size();
        vector<int> freq(26, 0);
        
        vector<int> sizes;
        for (string word : words) {
            sizes.push_back(word.size());
            for (char ch : word) {
                freq[ch - 'a']++;
            }
        }
        
        int even = 0;
        int single = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 0) {
                even += freq[i];
            } else {
                single += 1;
                even += (freq[i] - 1);
            }
        }
        
        sort(sizes.begin(), sizes.end());
        int res = 0;
        
        for (int i = 0; i < len; i++) {
            int lenW = sizes[i];
            if (lenW % 2 == 0) {
                if (even >= lenW) {
                    even -= lenW;
                    res++;
                }
            } else if (lenW % 2 == 1) {
                if (single > 0 && even >= (lenW - 1)) {
                    single--;
                    even -= (lenW - 1);
                    res++;
                    continue;
                }
                
                if (single == 0 && even > lenW) {
                    even -= (lenW + 1);
                    single++;
                    res++;
                    continue;
                } 
            }
        }
        
        return res;
        
    }
    
};