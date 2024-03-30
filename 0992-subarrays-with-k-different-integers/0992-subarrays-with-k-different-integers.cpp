class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        int res = subArraysWithLessThanEqualKDistinct(nums, k) - subArraysWithLessThanEqualKDistinct(nums, k - 1);

        return res;
    }

private:
    int subArraysWithLessThanEqualKDistinct(vector<int>& nums, int k) {
        int len = nums.size();

        map<int, int> freq;
        long long res = 0;
        for (int beg = 0, end = 0; end < len; end++) {
            int num = nums[end];
            freq[num]++;

            while (beg <= end && freq.size() > k) {

                int del = nums[beg];
                freq[del]--;
                beg++;

                if (freq[del] == 0) {
                    freq.erase(del);
                }
            }

            res += (end - beg + 1);

        }

        return res;
    }
};