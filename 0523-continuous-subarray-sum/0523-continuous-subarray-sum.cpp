class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();

        if (n == 1) return false;

        vector<int> temp(nums.begin(), nums.end());

        for (int i = 0; i < n; i++) {
            temp[i] = temp[i] % k;
        }

        bool res = false;
        res = res || isPossible(temp, 0) || isPossible(temp, k) || isPossible(temp, 2LL * k);

        return res;
    }

private:
    bool isPossible(vector<int> &temp, long long k) {
        int n = temp.size();
        long long currSum = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            // cout << "beg: " << beg << ", end: " << end << ", currSum: " << currSum << endl;

            currSum += temp[end];

            if (currSum == k && end - beg + 1 >= 2) {
                return true;
            }

            while (currSum > k && beg <= end - 1) {
                currSum -= temp[beg];
                beg++;

                if (currSum == k && end - beg + 1 >= 2) {
                    return true;
                }
            }

        }

        return false;
    }
};