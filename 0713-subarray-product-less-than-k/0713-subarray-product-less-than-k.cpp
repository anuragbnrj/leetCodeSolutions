class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int len = nums.size();

        long long tot = 0;
        long long currPr = 1;
        for (int beg = 0, end = 0; end < len; end++) {
            currPr *= nums[end];

            while (currPr >= k && beg <= end) {
                currPr /= nums[beg];
                beg++;
            }

            tot += (end - beg + 1);
        }

        return tot; 
    }
};