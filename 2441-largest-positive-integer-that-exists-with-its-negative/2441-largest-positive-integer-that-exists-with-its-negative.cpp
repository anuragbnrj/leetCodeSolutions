class Solution {
public:
    int findMaxK(vector<int>& nums) {
        int res = 0;
        unordered_set<int> stt(nums.begin(), nums.end());

        for (int i = 0; i < nums.size(); i++) {
            if (stt.find(nums[i] * -1) != stt.end()) {
                res = max(res, nums[i]);
            }
        }

        return res == 0 ? -1 : res;
    }
};