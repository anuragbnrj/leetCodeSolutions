class Solution {
public:
    int longestOnes(vector<int>& a, int k) {
        int n = a.size();

        int currZeros = 0;
        int maxLen = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            if (a[end] == 0) {
                currZeros++;
            }

            while (currZeros > k) {
                if (a[beg] == 0) {
                    currZeros--;
                }
                beg++;
            }

            maxLen = max(maxLen, end - beg + 1);
        }

        return maxLen;
        
    }
};