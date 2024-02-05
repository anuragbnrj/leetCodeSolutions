class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        int len = nums.size();
        unordered_map<int, int> windowElements;
        long long res = 0LL;
        long long currSum = 0LL;
        for (int beg = 0, end = 0; end < len; end++) {
            currSum += nums[end];
            windowElements[nums[end]]++;

            int currLen = end - beg + 1;
            while (currLen > k) {
                currSum -= nums[beg];
                windowElements[nums[beg]]--;

                if (windowElements[nums[beg]] == 0) {
                    windowElements.erase(nums[beg]);
                }
                beg++;
                currLen = end - beg + 1;
            }

            if (windowElements.size() == k) {
                res = max(res, currSum);
            }
        }

        return res;
    }
};