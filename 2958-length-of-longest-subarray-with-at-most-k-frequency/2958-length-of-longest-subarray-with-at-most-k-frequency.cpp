class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        int len = nums.size();

        map<int, int> freq;
        int maxLen = 0;
        for (int beg = 0, end = 0; end < len; end++) {
            freq[nums[end]]++;

            // cout << "end: " << end << " nums[end]: " << nums[end] << " freq: " << freq[nums[end]] << endl;

            while (beg < end && freq[nums[end]] > k) {
                if (freq[nums[beg]] > 0) {
                    freq[nums[beg]]--;
                }
                beg++;
            }

            // cout << "end: " << end << " beg: " << beg << endl;
            maxLen = max(maxLen, end - beg + 1);
        }

        return maxLen;
    }
};