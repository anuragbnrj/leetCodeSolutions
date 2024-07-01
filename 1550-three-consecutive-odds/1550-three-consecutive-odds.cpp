class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int n = arr.size();

        int currSum = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            currSum += (arr[end] % 2);

            if (end - beg + 1 > 3) {
                currSum -= (arr[beg] % 2);
                beg++;
            }

            if (currSum == 3) {
                return true;
            }
        }

        return false;
    }
};