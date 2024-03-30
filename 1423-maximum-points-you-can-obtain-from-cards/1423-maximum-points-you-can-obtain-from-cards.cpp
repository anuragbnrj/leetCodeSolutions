class Solution {
public:
    int maxScore(vector<int>& a, int k) {
        int n = a.size();
        int windowLen = n - k;
        int tot = accumulate(a.begin(), a.end(), 0);

        int minSum = INT_MAX;
        int currSum = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            currSum += a[end];

            if (end - beg + 1 > windowLen) {
                currSum -= a[beg];
                beg++;
            }

            if (end - beg + 1 == windowLen) {
                minSum = min(minSum, currSum);
            }
        }

        return (tot - minSum);
    }
};