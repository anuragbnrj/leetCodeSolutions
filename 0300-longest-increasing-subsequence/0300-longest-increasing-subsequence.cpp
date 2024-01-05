class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int len = nums.size();
        vector<int> lis(len, 1);
        int res = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = max(lis[i], lis[j] + 1);
                    res = max(res, lis[i]);
                }
            }
        }

        return res;
    }

};