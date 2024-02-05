class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        int len = nums.size();

        unordered_map<int, int> windowElements;
        int beg = 0, end = 0;
        long long res = 0LL;
        long long currSum = 0LL;
        while (end < len) {
            currSum += nums[end];
            windowElements[nums[end]]++;

            int currLen = end - beg + 1;
            if (currLen == k && windowElements.size() == k) {
                res = max(res, currSum);
            }

            if (currLen > k) {
                currSum -= nums[beg];
                windowElements[nums[beg]]--;

                if (windowElements[nums[beg]] == 0) {
                    windowElements.erase(nums[beg]);
                }
                beg++;

                int currLen = end - beg + 1;
                if (currLen == k && windowElements.size() == k) {
                    res = max(res, currSum);
                }
            }

            end++;
        }

        return res;
    }
};