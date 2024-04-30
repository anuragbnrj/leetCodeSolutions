class Solution {
public:
    long long wonderfulSubstrings(string word) {
        int n = word.size();

        map<int, int> freqCount;
        int xr = 0;
        freqCount[xr] = 1;
        long long res = 0;
        
        for (int i = 0; i < n; i++) {
            xr = xr ^ (1 << (word[i] - 'a'));
            res += freqCount[xr];
            for (int i = 0; i < 10; i++) {
                res += freqCount[xr ^ (1 << i)];
            }

            freqCount[xr]++;
        }

        return res;
    }
};