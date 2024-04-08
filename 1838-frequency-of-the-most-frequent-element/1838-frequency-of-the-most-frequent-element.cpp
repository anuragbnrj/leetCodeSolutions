class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        int n = nums.size();
        sort(nums.begin(), nums.end());

        int res = 1;
        long long currSum = 0;
        for (int beg = 0, end = 1; end < n; end++) {
            int diff = nums[end] - nums[end - 1];

            currSum += (1LL * (end - beg) * diff);

            while (beg < end && currSum > k) {
                int del = nums[beg];
                currSum -= (nums[end] - del);
                beg++;
            }

            res = max(res, end - beg + 1);
        }

        return res;   
    }
};